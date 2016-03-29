package com.bni.switchnode.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.bni.switchnode.constant.NetConstant;

public class JFrameView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private static int FRAME_WIDTH=1600;//frame��
	private static int FRAME_HEIGHT=1300;//frame��
	
	public static JFrameView instance=null;
	private JFrameView(){
	}
	
	public static JFrameView getInstance(){
		if(instance==null){
			instance=new JFrameView();
		}
		return instance;
	}
	public void init(){
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    setSize(FRAME_WIDTH, FRAME_HEIGHT);  
	    setLocationRelativeTo(null);  
	    setVisible(true);  
	}
	public JFrameView setJFrameTitle(String title){
		setTitle(title);
		return this;
	}
    public JFrameView setJPanel(JPanel panel){
 
    	getContentPane().add(panel);
    	
    	
    	return this;
    }
}
