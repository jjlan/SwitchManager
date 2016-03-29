package com.bni.switchnode.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.bni.switchnode.main.Entrance;

public class SocketToClient {

	public SocketToClient(){
		
	}
	static class GetSocket{
		static SocketToClient socketToClient=new SocketToClient();
	}
	public static SocketToClient getInstance(){
		return GetSocket.socketToClient;
	}
	ServerSocket socket=null;
	Socket clientSocket=null;
	InputStream is = null;
	public byte[] ReadFromClient(int length) {
		byte[] bytes = new byte[length];
		try {
			if (clientSocket != null) {
				is = clientSocket.getInputStream();
				int i = is.read(bytes, 0, length);
				if (i < 0) {
					Entrance.tv.append("Switch node is DOWN!\r\n");
					if (!clientSocket.isClosed())
						clientSocket.close();
					if (!socket.isClosed())
						socket.close();
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

	public  void InitSock(){
		try {
			socket=new ServerSocket(9000);
			System.out.println("listening");
			while((clientSocket= socket.accept())!=null){
//				byte[] length=new byte[4];
//				length= ReadFromClient(4);
//				int len= MsgUtil.ByteToInt(length);
//				byte [] command=new byte[len];
//				command=ReadFromClient(len);
//				System.out.println(new String(command));
				System.out.println(clientSocket.getLocalPort());
				BufferedReader br=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				System.out.println("vv");
				String string= br.readLine();
				
				System.out.println(string);
				br.close();
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
