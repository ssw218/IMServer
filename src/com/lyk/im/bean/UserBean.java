package com.lyk.im.bean;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class UserBean {
	
	public static final String TABLE_NAME = "user_info";
	public static final String ID = "id";
	public static final String USER_NAME = "user_name";
	public static final String PASSWORD = "password";
	public static final String FRIENDS = "friends";
	public static final String GROUPS = "groups";
	public static final String FRIEND_CATEGORY = "friend_category";
	public static final String GROUP_CATEGORY = "group_category";
	public static final String FIRST_REGISTER = "first_register";
	public static final String LAST_ONLINE = "last_online";
	public static final String IPS = "ips";
	
	private int id;
	private String userName;
	private String password;
	private String friends;
	private String groups;
	private String friendCategory;
	private String groupCategory;
	private Timestamp firstRegister;
	private Timestamp lastOnline;
	private String ips;
	
	
	public UserBean() {
		id = 0;
		userName = null;
		password = null;
		friends = null;
		groups = null;
		friends = null;
		groups = null;
		friendCategory = null;
		groupCategory = null;
		firstRegister = null;
		lastOnline = null;
	}
	
	public ArrayList<String> getAllFriends() {
		ArrayList<String> friendList = new ArrayList<String>();
		// (lyk|kyl),(lhy) 
		String[] friendArray = friends.split(",");
		for(String next: friendArray) {
			String[] temp = next.split("|");
			for(String next2: temp) {
				friendList.add(next2);
			}
		}
		return friendList;
	}
	
	public HashMap<String, ArrayList<String>> getFriendsAndCategory() {
		HashMap<String, ArrayList<String>> friendsMap = new HashMap<String, ArrayList<String>>();
		ArrayList<String> friendCategoryList = getAllFriendCategory();
		String[] friendArray = friends.split(",");
		for(int i = 0; i < friendArray.length; i++) {
			String[] temp = friendArray[i].split("|");
			ArrayList<String> friendsList = new ArrayList<String>();
			friendsList.clear();
			friendsMap.put(friendCategoryList.get(i), friendsList);
			for(String next2: temp) {
				friendsList.add(next2);
			}
		}
		return friendsMap;
	}
	
	public ArrayList<String> getAllFriendCategory() {
		ArrayList<String> friendCategoryList = new ArrayList<String>();
		for(String next: friendCategory.split(",")) {
			friendCategoryList.add(next);
		}
		return friendCategoryList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFriends(String friends) {
		this.friends = friends;
	}

	public String getGroups() {
		return groups;
	}

	public void setGroups(String groups) {
		this.groups = groups;
	}

	public String getFriendCategory() {
		return friendCategory;
	}

	public void setFriendCategory(String friendCategory) {
		this.friendCategory = friendCategory;
	}

	public String getGroupCategory() {
		return groupCategory;
	}

	public void setGroupCategory(String groupCategory) {
		this.groupCategory = groupCategory;
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
	
	
	
}
