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
	
	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public DatabaseDao() {
		DatebaseInfo info = new DatebaseInfo();
		info.readDatebaseInfo();
		DatabaseBean bean = info.getDatebaseInfo();
		String url = "jdbc:mysql://" + bean.getServer() + ":" + bean.getPort() + "/" + bean.getDatabase();
		try {
			mConnection = DriverManager.getConnection(url, bean.getUser(), bean.getPassword());
			mStatement = mConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void select() {
		String sql = "select * from user_info";
		try {
			ResultSet result = mStatement.executeQuery(sql);
			while(result.next()) {
				System.out.println(result.getString("user_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
