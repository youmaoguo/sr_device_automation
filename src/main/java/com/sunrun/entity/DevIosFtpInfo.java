package com.sunrun.entity;

import java.io.Serializable;

/**
 * 各型号设备登陆ftp下载ios版本信息
 * @author ymg
 *
 */
public class DevIosFtpInfo extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String brandName;//品牌名称
	private String modelName;//型号
	private String telnetType;//管理口登录协议
	private String telnetUser;//管理口登录用户
	private String telnetPwd;//管理口登录密码
	private String telnetPort;//管理口登录端口
	private String consoleTelnetUser;//console口登录用户
	private String consoleTelnetPwd;//console口登录密码
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getTelnetType() {
		return telnetType;
	}
	public void setTelnetType(String telnetType) {
		this.telnetType = telnetType;
	}
	public String getTelnetUser() {
		return telnetUser;
	}
	public void setTelnetUser(String telnetUser) {
		this.telnetUser = telnetUser;
	}
	public String getTelnetPwd() {
		return telnetPwd;
	}
	public void setTelnetPwd(String telnetPwd) {
		this.telnetPwd = telnetPwd;
	}
	public String getTelnetPort() {
		return telnetPort;
	}
	public void setTelnetPort(String telnetPort) {
		this.telnetPort = telnetPort;
	}
	public String getConsoleTelnetUser() {
		return consoleTelnetUser;
	}
	public void setConsoleTelnetUser(String consoleTelnetUser) {
		this.consoleTelnetUser = consoleTelnetUser;
	}
	public String getConsoleTelnetPwd() {
		return consoleTelnetPwd;
	}
	public void setConsoleTelnetPwd(String consoleTelnetPwd) {
		this.consoleTelnetPwd = consoleTelnetPwd;
	}
	@Override
	public String toString() {
		return "DevIosFtpInfo [brandName=" + brandName + ", modelName="
				+ modelName + ", telnetType=" + telnetType + ", telnetUser="
				+ telnetUser + ", telnetPwd=" + telnetPwd + ", telnetPort="
				+ telnetPort + ", consoleTelnetUser=" + consoleTelnetUser
				+ ", consoleTelnetPwd=" + consoleTelnetPwd + "]";
	}
	

}
