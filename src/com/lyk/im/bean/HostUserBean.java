package com.lyk.im.bean;

public class HostUserBean extends BaseUserBean {
	
	private String mFriends;
	private String mGroups;
	
	public HostUserBean() {
		super();
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
