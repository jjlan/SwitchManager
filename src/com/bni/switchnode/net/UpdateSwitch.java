package com.bni.switchnode.net;

import java.util.Arrays;
import com.bni.switchnode.constant.BlockConstant;
import com.bni.switchnode.constant.LineConstant;
import com.bni.switchnode.constant.NetConstant;
import com.bni.switchnode.domain.ImageParameter;
import com.bni.switchnode.main.Entrance;

public class UpdateSwitch {
	public static void updateSwitchInfoAll(String str,byte[] commandBuffer,char commandType){
		int packageId= MsgUtil.ByteToInt(Arrays.copyOfRange(commandBuffer, NetConstant.package_id_position,
				NetConstant.package_id_position+commandBuffer.length));
		Entrance.tv.append(str+"\r\n");
		String str1=new String(commandBuffer);
		String[] str2= str1.split("\\$");
		int m=0;
		for(int j=0;j<str2[1].length();j++){
			m++;
			ImageParameter.blockMap.get(BlockConstant.BLOCK_FIBER)
			.setColor(LineConstant.usedColor);
			int  t= Integer.parseInt(String.valueOf(str2[1].toCharArray()[j]));
			if (m % 2 == 0) {
				ImageParameter.fiberMap.get(t+4).setColor(LineConstant.usedColor);
				
			}
			else {
				ImageParameter.fiberMap.get(t).setColor(LineConstant.usedColor);
			}
		}
		
		m=0;
		if (!str2[2].equals("0")) {
			ImageParameter.blockMap.get(BlockConstant.BLOCK_BAND).setColor(LineConstant.usedColor);
			for (int j = 0; j < str2[2].length(); j++) {
				m++;
				int t = Integer.parseInt(String.valueOf(str2[2].toCharArray()[j]));
				
				if (m % 2 == 0){
					ImageParameter.bandMap.get(t + 10).setColor(LineConstant.usedColor);
					if(t<=3){
						ImageParameter.PolygonMap.get(BlockConstant.HUB_1).setColor(LineConstant.usedColor);
					}
					else if(4<=t&&t<=6){
						ImageParameter.PolygonMap.get(BlockConstant.HUB_2).setColor(LineConstant.usedColor);
					}
				}
				else {
					ImageParameter.bandMap.get(t).setColor(LineConstant.usedColor);
					if(t<=3){
						ImageParameter.PolygonMap.get(BlockConstant.WSS1).setColor(LineConstant.usedColor);
					}
					else if(4<=t&&t<=6){
						ImageParameter.PolygonMap.get(BlockConstant.WSS2).setColor(LineConstant.usedColor);
					}
				}
			}
		}
		m=0;
		if (!str2[3].equals( "0")) {
			ImageParameter.blockMap.get(BlockConstant.BLOCK_WAVE).setColor(LineConstant.usedColor);
			for (int j = 0; j < str2[3].length(); j++) {
				m++;
				int t = Integer.parseInt(String.valueOf(str2[3].toCharArray()[j]));
				if (m % 2 == 0){
					ImageParameter.lengthMap.get(t + 10).setColor(LineConstant.usedColor);
					if(t<=3)
						ImageParameter.PolygonMap.get(BlockConstant.DWDM_3).setColor(LineConstant.usedColor);
					else if(t<=5&&t>=4) {
						ImageParameter.PolygonMap.get(BlockConstant.DWDM_4).setColor(LineConstant.usedColor);
					}
					else {
						ImageParameter.blockMap.get(BlockConstant.RX).setColor(LineConstant.usedColor);
					}
				}
				else {
					ImageParameter.lengthMap.get(t).setColor(LineConstant.usedColor);
					if(t<=3)
						ImageParameter.PolygonMap.get(BlockConstant.DWDM_1).setColor(LineConstant.usedColor);
					else if(t<=5&&t>=4) {
						ImageParameter.PolygonMap.get(BlockConstant.DWDM_2).setColor(LineConstant.usedColor);
					}
					else {
						ImageParameter.blockMap.get(BlockConstant.TX).setColor(LineConstant.usedColor);
					}
				}
			}
		}

	}
}
