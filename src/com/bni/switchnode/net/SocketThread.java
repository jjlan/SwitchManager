package com.bni.switchnode.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.bni.switchnode.constant.NetConstant;
import com.bni.switchnode.main.Entrance;
import com.bni.switchnode.view.JPanelView;


public class SocketThread implements Runnable{
	public ServerSocket serverSocket=null;
	Socket Clientsocket;
	public SocketThread(){
	}
	public static class GetSock{
		 static SocketThread sThread=new SocketThread();
	}
	
	public static SocketThread getInstance(){
		return GetSock.sThread;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		InitSock();
	}
	
	public void InitSock(){
		try {
			if(serverSocket==null)
				serverSocket=new ServerSocket(NetConstant.hardware_listen_port);
			
			Entrance.tv.append("Server started successfully!\r\n");
			Entrance.tv.append("Waiting for switch node....\r\n");
			if( (Clientsocket= serverSocket.accept())==null){
				serverSocket.close();
				return;
			}
			Entrance.tv.append("client connected:"+Clientsocket.getInetAddress().getHostAddress()+"\r\n");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread( new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ClientThread();
			}
		}).start();
	}

	InputStream is = null;
	public byte[] ReadFromClient(int length) {
		byte[] bytes = new byte[length];
		try {
			if (Clientsocket != null) {
				is = Clientsocket.getInputStream();
				int i = is.read(bytes, 0, length);
				if (i < 0) {
					Entrance.tv.append("Switch node is DOWN!\r\n");
					if (!Clientsocket.isClosed())
						Clientsocket.close();
					if (!serverSocket.isClosed())
						serverSocket.close();
					return null;
				}
				return bytes;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	JPanelView jView;
	public void WriteToClient(byte [] ack,JPanelView jview){
		this.jView=jview;
		OutputStream os = null;
		try {
			if (Clientsocket != null) {	
				os = Clientsocket.getOutputStream();
				byte[] bytes=MsgUtil.IntToByte(ack.length);
				os.write(bytes);
				os.write(ack);
				os.flush();
			}
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
	public int checkHardware(byte [] hardware_status){
		if(hardware_status[0]==NetConstant.DEVICES_OK){
			Entrance.tv.append("Checking switch node...OK!\r\n");
			System.out.println("status:"+hardware_status[0]);
			return NetConstant.CHECK_OK;
		}
		else {
			Entrance.tv.append("Switch node startup failed!\r\n Please check the device!\r\n");
			System.out.println("status:"+hardware_status[0]);
			//InitSock();
			return NetConstant.CHECK_ERROR;
		}
	}
	boolean isChecked=false;

	public int ClientThread() {
		while (true) {
			byte[] data = ReadFromClient(NetConstant.head_length);
			if (data == null) {
				return NetConstant.NodeClosed;
			}
			int length_data = MsgUtil.ByteToInt(data);
			byte[] databuff = new byte[length_data];
			databuff = ReadFromClient(length_data);
			System.out.println("receiveData:"+ new String(databuff) );
			if(!isChecked){
				isChecked=true;
				if(checkHardware(databuff)!=NetConstant.CHECK_OK){
					System.out.println("device Error");
					 return NetConstant.CHECK_ERROR;
				}
				System.out.println("device OK");
				continue;
			}
			processCommondFromHardware(databuff,length_data);
		}
	}
	//Map<Integer, MsgInfo> commandMap=new HashMap<>();
	public void processCommondFromHardware(byte [] commondBuffer,int length){
		Map<Integer,  MsgInfo> iteMap=new HashMap<>();
		int packageId;
		switch (commondBuffer[0]) {
		case NetConstant.MESSAGE_OK:
			Entrance.tv.append("OK\r\n");
			Arrays.copyOf(commondBuffer, 4);
			packageId=MsgUtil.ByteToInt(Arrays.copyOfRange(commondBuffer, NetConstant.package_id_position, NetConstant.package_id_position+4));
	//		iteMap.put(packageId, commandMap.get(packageId));
		//	commandMap.remove(packageId);
			
			break;
		case NetConstant.MESSAGE_ERR:
			Entrance.tv.append("failed\r\n");
			packageId=MsgUtil.ByteToInt(Arrays.copyOfRange(commondBuffer, NetConstant.package_id_position, NetConstant.package_id_position+4));
		//	iteMap.put(packageId, commandMap.get(packageId));
//			if(--iteMap.get(packageId).retryTimes>0){
//				sendAgain(packageId);
//			}
			
//			else {
//				commandMap.remove(packageId);
//			//	addErrToDialog(packageId);
//			}
		case NetConstant.FIBER_OK:
			 UpdateSwitch.updateSwitchInfoAll("Fiber switch successfully.\r\n",commondBuffer,NetConstant.Command_Connect);
//			updateSwitchInfoAll("Fiber switch successfully.\r\n",commondBuffer,NetConstant.Command_Connect);
			jView.updateUI();
			 break;
		case NetConstant.BAND_OK:
			 UpdateSwitch.updateSwitchInfoAll("WaveBand switch successfully.\r\n",commondBuffer,NetConstant.Command_Connect);
//			updateSwitchInfoAll("WaveBand switch successfully.\r\n",commondBuffer,NetConstant.Command_Connect);
			 jView.updateUI();
			 break;
		case NetConstant.WAVELENGTH_OK:
			UpdateSwitch.updateSwitchInfoAll("Wavelength switch successfully.\r\n",commondBuffer,NetConstant.Command_Connect);
			jView.updateUI();
			break;
			
		default:
			break;
		}
	}

}
