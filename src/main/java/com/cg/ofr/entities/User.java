package com.cg.ofr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userDetails")
public class User {

	@Id
	private int userId;
	private String userName;
	private String password;
	private String userType;

	public User() {

	}

	public User(int userId, String userName, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", userType=" + userType
				+ "]";
	}

}
