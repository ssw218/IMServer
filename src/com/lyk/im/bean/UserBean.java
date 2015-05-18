package com.lyk.im.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class UserBean extends HostUserBean {
	private String id;
	private String phone;
	private String password;
	private Timestamp firstRegister;
	private Timestamp lastOnline;
	private String ips;
	
	
	public UserBean() {
		super();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getFirstRegister() {
		return firstRegister;
	}

	public void setFirstRegister(Timestamp firstRegister) {
		this.firstRegister = firstRegister;
	}

	public Timestamp getLastOnline() {
		return lastOnline;
	}

	public void setLastOnline(Timestamp lastOnline) {
		this.lastOnline = lastOnline;
	}

	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getPhoneNumber() {
		return phone;
	}
	
	
	
}
