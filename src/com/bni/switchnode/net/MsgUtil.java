package com.bni.switchnode.net;


/**
 * ���ܣ���������ת����
 * @author hjj
 *
 */
public final class MsgUtil {
	/*
	 * ��int�����ݲ�ֳ�byte����
	 */
	public static byte[] IntToByte(int n){
		byte[] b=new byte[4];
		b[3]=(byte)(n>>24);
		b[2]=(byte)(n>>16);
		b[1]=(byte)(n>>8);
		b[0]=(byte)n;
		return b;
	}
	/*
	 * ��byte[]�����ݺϳ�int������
	 * java����λbyte��ʱ���ȻὫbyteװ����int�����յõ�����int�͵�����
	 */
	public static int ByteToInt(byte[] b){
	
			return  b[0]& 0xff|(b[1]&0xff)<<8|(b[2]&0xff)<<16|(b[3]&0xff)<<24;
		
	}
	/*
	 * ��byte[]������ת����short������
	 */
	 public static short byteToShort(byte b[]) {
	        return (short) (b[1] & 0xff | (b[0] & 0xff) << 8) ;
	 }
	 /*
	  * ��IP��ַת�����ֽ�����
	  */
	 public static int[] IpToByte(String strIp){
		 int[] ips = new int[4];  
	   //���ҵ�IP��ַ�ַ�����.��λ��   
        int position1 = strIp.indexOf(".");   
        int position2 = strIp.indexOf(".", position1 + 1);   
        int position3 = strIp.indexOf(".", position2 + 1);   
        //��ÿ��.֮����ַ���ת��������?   
        ips[0] = Integer.parseInt(strIp.substring(0, position1));   
        ips[1] = Integer.parseInt(strIp.substring(position1+1, position2));   
        ips[2] = Integer.parseInt(strIp.substring(position2+1, position3));   
        ips[3] = Integer.parseInt(strIp.substring(position3+1));             
        return ips;         
	 }
	 /*
	  * ���ֽ�����ת����IP
	  */
	 public static String ByteToIp(int[] ips){
		 StringBuilder sb=new StringBuilder();
		 sb.append(ips[0]); 
		 sb.append(".");
		 sb.append(ips[1]);
		 sb.append(".");
		 sb.append(ips[2]);
		 sb.append(".");
		 sb.append(ips[3]);
		 return sb.toString();
	 }

}
