package com.cruds.beans;

public class UserBean {
	String userType;
	String userName;
	String password;
	public UserBean(String userType, String userName, String password) {
		super();
		this.userType = userType;
		this.userName = userName;
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	@Override
	public String toString() {
		return "UserBean [userType=" + userType + ", userName=" + userName + ", password=" + password + "]";
	}
	
	
}
