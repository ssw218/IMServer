package com.lyk.im.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lyk.im.bean.DatabaseBean;
import com.lyk.im.util.DatebaseInfo;

public class DatabaseDao {
	
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	private Connection mConnection;
	private Statement mStatement;
	
	public DatabaseDao() {
		init();
		String url = "jdbc:mysql://127.0.0.1:3306/instant_messaging";
		try {
			mConnection = DriverManager.getConnection(url, "root", "123456");
			mStatement = mConnection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DatabaseDao(String path) {
		init();
		
		DatebaseInfo info = new DatebaseInfo();
		info.readDatebaseInfo(path);
		DatabaseBean bean = info.getDatebaseInfo();
		//System.out.println(bean);
		String url = "jdbc:mysql://" + bean.getServer() + ":" + bean.getPort() + "/" + bean.getDatabase();
		try {
			mConnection = DriverManager.getConnection(url, bean.getUser(), bean.getPassword());
			mStatement = mConnection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private void init() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Statement getStatement() {
		return mStatement;
	}
	
	public void select() {
		String sql = "select * from user_info";
		try {
			ResultSet result = mStatement.executeQuery(sql);
			while(result.next()) {
				System.out.println(result.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
