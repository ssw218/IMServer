package com.lyk.im.service;

import java.io.IOException;
import java.io.PrintWriter;

import com.lyk.im.bean.UserBean;
import com.lyk.im.dao.UserInfoDao;

public class RegisterService {
	public static boolean doRegister(String path, UserBean user) {
		UserInfoDao userInfoDao = new UserInfoDao(path);
		boolean result = userInfoDao.checkPhoneNumber(user.getPhoneNumber());
		if (result) {
			return false;
		} else {
			//userInfoDao.insert(user);
			return true;
		}
		
	}
	
}
