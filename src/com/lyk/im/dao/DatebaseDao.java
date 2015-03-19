package com.lyk.im.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatebaseDao {
	
	private static final String USER = "root";
	private static final String PASSWORD = "123456";
	private static final String SQL_IP = "localhost";
	private static final String DATEBASE = "instant_messaging";
	private static final String URL = "jdbc:mysql://" + SQL_IP + "/" + DATEBASE;
	private static final String DRIVER = "com.mysql.jdbc.mysql";
	
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
	
	public DatebaseDao() {
		try {
			mConnection = DriverManager.getConnection(URL, USER, PASSWORD);
			mStatement = mConnection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
