package com.lyk.im.util;

import java.io.File;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.lyk.im.bean.DatabaseBean;

public class DatebaseInfo {
	private static final String SERVER = "server";
	private static final String PORT = "port";
	private static final String DATABASE = "database";
	private static final String USER_NAME = "username";
	private static final String PASSWORD = "password";
	
	private DatabaseBean info;
	
	public DatebaseInfo() {
		info = new DatabaseBean();
	}
	
//	public void readDatebaseInfo() {
//		info.setServer("127.0.0.1");
//		info.setPort("3306");
//		info.setDatebase("instant_messaging");
//		info.setUser("root");
//		info.setPassword("123456");
//	}
	
	public void readDatebaseInfo(String path) {
		System.out.println("readDatebaseInfo");
		File file = new File(path + "\\Resources\\MySQLConfig.xml");
//		if(!file.exists()) {
//			throw new IllegalAccessException("file not found");
//		}
		
		SAXBuilder sb = new SAXBuilder();
		try {
			Document doc = sb.build(file);
			Element root = doc.getRootElement();
			Element child = root.getChild("datasource");
//			List<Element> list = child.getChildren();
//			System.out.println(child.getValue());
			info.setServer(child.getChildText(SERVER));
			info.setPort(child.getChildText(PORT));
			info.setDatebase(child.getChildText(DATABASE));
			info.setUser(child.getChildText(USER_NAME));
			info.setPassword(child.getChildText(PASSWORD));
//			System.out.println(info.toString());
		} catch (JDOMException | IOException e) {
			e.printStackTrace();
		} finally {
			//System.out.println(info.toString());
		}
	}
	
	public DatabaseBean getDatebaseInfo() {
		return info;
	}
	
}
