package com.lyk.im.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lyk.im.bean.BaseUserBean;
import com.lyk.im.bean.HostUserBean;

public class UserInfoDao extends DatabaseDao {
	private static final String TABLE_NAME = "user_info";
	
	private static final String USER_NAME = "user_name";
	private static final String INTRODUCE = "introduce";
	private static final String PHOTO = "photo";
	private static final String FRIENDS = "friends";
	private static final String GROUPS = "groups";
	private static final String ID = "id";
	private static final String PASSWORD = "password";
	private static final String FIRST_REGISTER = "first_register";
	private static final String LAST_ONLINE = "last_online";
	private static final String IPS = "ips";
	
	public UserInfoDao(String path) {
		super(path);
	}
	
	public boolean checkUser(String id, String password) {
		// select id from user_info where user_name='lyk' and password='123456'
		System.out.println("checkUser");
		String sql = "select * from " + TABLE_NAME + " where " + ID + "='" 
				+ id + "' and " + PASSWORD + "='" + password + "'";
		ResultSet resultSet = null;
		try {
			resultSet = getStatement().executeQuery(sql);
			if (resultSet.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public HostUserBean getHostUserInfo(String id){
		System.out.println("getHostUserInfo");
		HostUserBean user = new HostUserBean();
		// select user_name,photo,friends,groups,introduce from user_info where id=1
		String sql = "select " + USER_NAME + "," + PHOTO + "," + FRIENDS + "," + GROUPS + "," + INTRODUCE + 
				" from " + TABLE_NAME + " where " + ID + "=" + id;
		ResultSet resultSet = null;
		try {
			resultSet = getStatement().executeQuery(sql);
			while(resultSet.next()) {
				user.setUserName(resultSet.getString(USER_NAME));
				user.setPhoto(resultSet.getString(PHOTO));
				user.setFriends(resultSet.getString(FRIENDS));
				user.setGroups(resultSet.getString(GROUPS));
				user.setIntroduce(resultSet.getString(INTRODUCE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	public BaseUserBean getBaseUserInfo(String id) {
//		select user_name,photo,introduce from user_info where id=2;
		BaseUserBean user = new BaseUserBean();
		String sql = "select " + USER_NAME + "," + PHOTO + "," + INTRODUCE + " from " + 
				TABLE_NAME + " where " + ID + "=" + id;
		ResultSet resultSet = null;
		try {
			resultSet = getStatement().executeQuery(sql);
			while (resultSet.next()) {
				user.setUserName(resultSet.getString(USER_NAME));
				user.setPhoto(resultSet.getString(PHOTO));
				user.setIntroduce(resultSet.getString(INTRODUCE));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
}
