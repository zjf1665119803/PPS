package com.guigu.pojo;
/**
 * 用户实体类
 * @author ZJF
 *
 */

public class User {
	private String UserID;
	private String UserName;
	private String PasswordCode;
	private int IsUse;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPasswordCode() {
		return PasswordCode;
	}
	public void setPasswordCode(String passwordCode) {
		PasswordCode = passwordCode;
	}
	public int getIsUse() {
		return IsUse;
	}
	public void setIsUse(int isUse) {
		IsUse = isUse;
	}
	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", UserName=" + UserName + ", PasswordCode=" + PasswordCode + ", IsUse="
				+ IsUse + "]";
	}
	
}
