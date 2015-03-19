package com.lyk.im.util;

import java.io.File;

import com.lyk.im.bean.DatebaseBean;

public class DatebaseInfo {
	
	private DatebaseBean info;
	
	public DatebaseInfo() {
		readDatebaseInfo();
	}
	
	private void readDatebaseInfo() {
		info = new DatebaseBean();
		File file = new File("Resources\\MySQLConfig.xml");
		System.out.println(file.exists());
	}
	
}
