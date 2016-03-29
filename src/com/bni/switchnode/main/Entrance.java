package com.bni.switchnode.main;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import com.bni.switchnode.constant.NetConstant;
import com.bni.switchnode.domain.ImageParameter;
import com.bni.switchnode.net.JointSignal;
import com.bni.switchnode.net.SocketThread;
import com.bni.switchnode.net.SocketToClient;
import com.bni.switchnode.view.JFrameView;
import com.bni.switchnode.view.JPanelView;

public class Entrance {
	public static void main(String[] args) {
		ImageParameter.initImage();
		JFrameView jFrame=JFrameView.getInstance();
		jFrame.init();
		jFrame.setTitle("SwitchNode"); 
		Entrance entrance=new Entrance();
		entrance.Init();
		jFrame.setJPanel(entrance.panelContainer);
		SocketToClient.getInstance().InitSock();
		//new Thread(SocketThread.getInstance()).start();
    	
	}
	public static TextArea tv=new TextArea();
	JPanel panelContainer=new JPanel();
    public  void Init()
    {
    	JPanel jPanel=new JPanel();
		jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
    	JButton jButton=new JButton(NetConstant.ButtonName);
    	jPanel.setAlignmentY(Component.TOP_ALIGNMENT ); 
    	jPanel.add(tv);
    	jPanel.add(Box.createVerticalStrut(5));
    	jPanel.add(jButton);
    	
    	final JPanelView  jView=new JPanelView();
    	panelContainer.setLayout(new GridBagLayout());
     	GridBagConstraints c1 = new GridBagConstraints();
    	c1.gridx=1;
    	c1.gridy=0;
    	c1.weightx = 0.3;
    	c1.weighty =0.0;
    	c1.gridwidth=5;
    	c1.gridheight=2;
    	c1.fill = GridBagConstraints.NONE;
    	panelContainer.add(jPanel, c1);
        
    	GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 0;
		c2.weightx = 1.0;
		c2.weighty = 1.0;
		c2.fill = GridBagConstraints.BOTH;
		panelContainer.add(jView, c2);
		
		
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				final String []userData=new String[3];
				userData[0] = "10.109.0.3,1566.723,1565.496,1565.905,10.109.0.1,10.109.0.2";
				userData[1]  = "10.108.0.2,1543.730,1565.087,1564.679,10.109.0.2,0";
				userData[2] = "10.108.0.3,1564.271,1563.863,1563.455,10.109.0.2,0";
			  	
			  	final String sendBand="1$0$0$3$10.108.0.1,1566.723,1565.496,1565.905,10.109.0.1,0$10.108.0.2,1543.730,1565.087,1564.679,10.109.0.2,0$10.108.0.3,1564.271,1563.863,1563.455,10.109.0.1,0$&0002";
			  	final String sendFiber="0$0$10.109.0.1$3$10.108.0.1,1566.723,1565.496,1565.905,10.109.0.1,0$10.108.0.2,1543.730,1565.087,1564.679,10.109.0.1,0$10.108.0.3,1564.271,1563.863,1563.455,10.109.0.1,0$&0002";
			  
			   	final String sendWavelength="2$1$0$3$10.109.0.3,1566.723,1565.496,1565.905,10.109.0.1,10.109.0.2$10.108.0.2,1543.730,1565.087,1564.679,10.109.0.2,0$10.108.0.3,1564.271,1563.863,1563.455,10.109.0.2,0$&0002";
			  	new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
//						SocketThread.getInstance().WriteToClient(sendWavelength.getBytes(),jView);
						
						String send= JointSignal.JointCommand("&0002", 2, 0, "0", 3, userData);
						SocketThread.getInstance().WriteToClient(send.getBytes(),jView);
						
//						String tString="&0002";
//						SocketThread.getInstance().WriteToClient(tString.getBytes(), jView);
					}
				}).start();	
			}
		});
    }
}
