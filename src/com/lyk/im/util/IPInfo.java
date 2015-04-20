package com.lyk.im.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class IPInfo {
	
	private static final String API = "http://www.ip138.com/ip2city.asp";
	
	private IPInfo() {

	}
	
	public static String getHostIP() {
		String ip = null;
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return ip;
	}
	
	public static String getNetworkIP() {
		String ip = null;
		try {
			URL url = new URL(API);
			InputStream inputStream = url.openStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			StringBuffer buffer = new StringBuffer();
			String temp;
			while((temp = bufferedReader.readLine()) != null) {
				buffer.append(temp + "\r\n");
			}
			//System.out.println(buffer);
			int start = buffer.indexOf("[");
			int end = buffer.indexOf("]");
			if (start < 0 || end < 0) {
				return null;
			}
			ip = buffer.substring(start + 1, end);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ip;
	}

}
