package com.lyk.im.bean;

public class DatabaseBean {
	private String server;
	private String port; 
	private String database;
	private String user;
	private String password;
	
	public DatabaseBean() {
		
	}
	
	public String toString() {
		return "Server: " + server + "\n" +
				"Port: " + port + "\n" + 
				"Database: " + database + "\n" + 
				"User: " + user + "\n" +
				"Password: " + password;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatebase(String datebase) {
		this.database = datebase;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
