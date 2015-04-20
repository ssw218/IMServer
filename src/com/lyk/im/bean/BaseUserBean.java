package com.lyk.im.bean;

// Use for other friends
public class BaseUserBean {
	private String mUserName;
	private String mIntroduce;
	private String mPhoto;
	
	public BaseUserBean() {
		
	}
	
	public String getUserName() {
		return mUserName;
	}
	
	public void setUserName(String userName) {
		this.mUserName = userName;
	}
	
	public String getIntroduce() {
		return mIntroduce;
	}
	
	public void setIntroduce(String introduce) {
		this.mIntroduce = introduce;
	}
	
	public String getPhoto() {
		return mPhoto;
	}
	
	public void setPhoto(String photo) {
		this.mPhoto = photo;
	}
	
	
	
}
