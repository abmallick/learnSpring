package com.cruds.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class UserBean {
	@Id
	@Column(name = "userId")
	String userName;
	@Column(name = "userType")
	String userType;
	@Column(name = "password")
	String password;
	UserBean(){
	}
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
