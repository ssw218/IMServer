package com.lyk.im.bean;

public class HostUserBean extends BaseUserBean {
	private String mId;
	private String mPhone;
	private String mFriends;
	private String mGroups;
	
	public HostUserBean() {
		super();
	}
	
	
	
	public String getId() {
		return mId;
	}



	public void setId(String id) {
		this.mId = id;
	}



	public String getPhone() {
		return mPhone;
	}

	public void setPhone(String phone) {
		this.mPhone = phone;
	}



	public String[] getAllFriends() {
		String[] friendArray = mFriends.split(",");
		return friendArray;
	}
	
	public String[] getAllGroups() {
		String[] groupsArray = mGroups.split(",");
		return groupsArray;
	}
	
	public void setFriends(String friends) {
		this.mFriends = friends;
	}
	
	public String getFriends() {
		return mFriends;
	}

	public String getGroups() {
		return mGroups;
	}

	public void setGroups(String groups) {
		this.mGroups = groups;
	}
	
}
