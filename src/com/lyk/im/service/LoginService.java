package com.lyk.im.service;

import com.lyk.im.bean.HostUserBean;
import com.lyk.im.dao.UserInfoDao;

public class LoginService {
	private static final String HEAD = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private static final String TAG_USER_INFO = "userinfo";
	private static final String TAG_NAME = "name";
	private static final String TAG_PHOTO = "photo";
	private static final String TAG_FRIENDS = "friends";
	private static final String TAG_GROUPS = "groups";
	private static final String TAG_INTRODUCE = "introduce";
	
	/*
	 * <userinfo>
	 * 	<name>Li Yikun</name>
	 * 	<photo></photo>
	 * 	<friends></friends>
	 * 	<groups></groups>
	 * 	<introduce></introduce>
	 * </userinfo>
	 * */
	
	public static String getServletMessage(String path, String id, String password) {
		UserInfoDao userInfoDao = new UserInfoDao(path);
		boolean result = userInfoDao.checkUser(id, password);
		if (!result) {
			return "false";
		} else {
			HostUserBean user = userInfoDao.getHostUserInfo(id);
			StringBuffer xml = new StringBuffer(HEAD);
			xml.append("<" + TAG_USER_INFO + ">");
			xml.append("<" + TAG_NAME + ">");
			xml.append(user.getUserName());
			xml.append("</" + TAG_NAME + ">");
			xml.append("<" + TAG_PHOTO + ">");
			xml.append(user.getPhoto());
			xml.append("</" + TAG_PHOTO + ">");
			xml.append("<" + TAG_FRIENDS + ">");
			xml.append(user.getFriends());
			xml.append("</" + TAG_FRIENDS + ">");
			xml.append("<" + TAG_GROUPS + ">");
			xml.append(user.getGroups());
			xml.append("</" + TAG_GROUPS + ">");
			xml.append("<" + TAG_INTRODUCE + ">");
			xml.append(user.getIntroduce());
			xml.append("</" + TAG_INTRODUCE + ">");
			xml.append("</" + TAG_USER_INFO + ">");
			System.out.println(xml.toString());
			return xml.toString();
		}
	}
	
}
