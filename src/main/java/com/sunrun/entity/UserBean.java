package com.sunrun.entity;

import java.io.Serializable;



public class UserBean extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String userName;
	String passWord;
	String email;
	String userCode;
	String mobilePhone;
	Integer locked;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
 
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Integer getLocked() {
		return locked;
	}
	public Integer setLocked(Integer locked) {
		return this.locked = locked;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	
	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", passWord=" + passWord
				+ ", email=" + email + ", userCode=" + userCode
				+ ", mobilePhone=" + mobilePhone + ", locked=" + locked + "]";
	}
	
	
 
}
