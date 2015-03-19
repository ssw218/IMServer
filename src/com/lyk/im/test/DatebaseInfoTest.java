package com.lyk.im.test;

import com.lyk.im.bean.DatebaseBean;
import com.lyk.im.util.DatebaseInfo;

public class DatebaseInfoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatebaseInfo info = new DatebaseInfo();
		info.readDatebaseInfo();
		DatebaseBean bean = info.getDatebaseInfo();
		System.out.println(bean.toString());
	}

}
