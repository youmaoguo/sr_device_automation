package com.sunrun.util;

import java.net.*;
import java.nio.*;

/**
 * 打印出两个IP之间的所有IP值
 * 
 * @author hello
 *
 */
public class PrintIP {

	// 一个IP，是一个３２位无符号的二进制数。故用long的低32表示无符号32位二进制数。
	public static long getIP(InetAddress ip) {
		byte[] b = ip.getAddress();
		long l = b[0] << 24L & 0xff000000L | b[1] << 16L & 0xff0000L | b[2] << 8L & 0xff00L | b[3] << 0L & 0xffL;
		return l;
	}

	// 由低32位二进制数构成InetAddress对象
	public static InetAddress toIP(long ip) throws UnknownHostException {
		byte[] b = new byte[4];
		int i = (int) ip;// 低３２位
		b[0] = (byte) ((i >> 24) & 0x000000ff);
		b[1] = (byte) ((i >> 16) & 0x000000ff);
		b[2] = (byte) ((i >> 8) & 0x000000ff);
		b[3] = (byte) ((i >> 0) & 0x000000ff);
		return InetAddress.getByAddress(b);
	}

	public static void main(String[] args) throws UnknownHostException {
		long ip1 = getIP(InetAddress.getByName("192.168.1.0"));
		long ip2 = getIP(InetAddress.getByName("192.168.3.255"));
		System.out.println("192.168.0.233到192.168.1.12之间所有的IP是：");
		for (long ip = ip1; ip <= ip2; ip++) {
			System.out.println(toIP(ip).getHostAddress());
		}
	}
}