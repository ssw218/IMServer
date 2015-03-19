package com.lyk.im.test;

import com.lyk.im.bean.DatabaseBean;
import com.lyk.im.util.DatebaseInfo;

public class DatebaseInfoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatebaseInfo info = new DatebaseInfo();
		info.readDatebaseInfo();
		DatabaseBean bean = info.getDatebaseInfo();
		System.out.println(bean.toString());
	}

}
