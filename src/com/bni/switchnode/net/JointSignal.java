package com.bni.switchnode.net;

import com.bni.switchnode.constant.NetConstant;

public class JointSignal {
	private JointSignal() {

	}
	public static String JointCommand(String packageId, int switchType,
			int flag, String fiberIp, int userCount, String[] userData) {
		String commandBufferString = new String();
		commandBufferString = commandBufferString.concat(switchType
				+ NetConstant.SPLIT_CHAR + flag + NetConstant.SPLIT_CHAR
				+ fiberIp + NetConstant.SPLIT_CHAR + userCount
				+ NetConstant.SPLIT_CHAR);
		for (int i = 0; i < userData.length; i++) {
			commandBufferString = commandBufferString.concat(userData[i]
					+ NetConstant.SPLIT_CHAR);
		}
		commandBufferString = commandBufferString.concat(packageId);
		System.out.println(commandBufferString);
		return commandBufferString;
	}
}
