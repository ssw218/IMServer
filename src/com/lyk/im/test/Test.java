package com.lyk.im.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class Test {

	public static void main(String[] args) {
		String localIp = null;
		String serverIp = null;
		String localName = null;
		try {
			localIp = InetAddress.getAllByName("localhost")[0].getHostAddress();
			localName = InetAddress.getLocalHost().toString();
			serverIp = (InetAddress.getAllByName("lykim.nat123.net"))[0].getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(localIp);
		System.out.println(serverIp);
		System.out.println(localName);
	
		 System.out.println("本机的外网IP是：" + getWebIp("http://www.ip138.com/ip2city.asp"));
		
	}
	
	public static String getWebIp(String strUrl) {
		  try {

		   URL url = new URL(strUrl);

		   BufferedReader br = new BufferedReader(new InputStreamReader(url

		   .openStream()));

		   String s = "";

		   StringBuffer sb = new StringBuffer("");
		   
		   String webContent = "";

		   while ((s = br.readLine()) != null) {
		    sb.append(s + "\r\n");

		   }

		   br.close();
		   webContent = sb.toString();
		   int start = webContent.indexOf("[")+1;
		   int end = webContent.indexOf("]");
		   webContent = webContent.substring(start,end);
		   
		   return webContent;

		  } catch (Exception e) {
		   e.printStackTrace();
		   return "error open url:" + strUrl;

		  }
		 
		}

}
