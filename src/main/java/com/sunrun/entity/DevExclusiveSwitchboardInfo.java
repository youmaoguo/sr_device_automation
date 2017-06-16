package com.sunrun.entity;

import java.io.Serializable;

/**
 * 带外交换机信息
 * @author ymg
 *
 */
public class DevExclusiveSwitchboardInfo extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String exclusiveSwitchboardIp;	//'带外交机ip(console)',
	private String exclusiveSwitchboardPort;//'带外交机端口(console)',
	private Integer exclusiveSwitchboardOrder;//'带外交机顺序',
	private String exclusiveSwitchboardNote;//'带外交机要信息备注',
	private String telnetType;
	private String telnetUser;
	private String telnetPwd;
	private String telnetPort;
	private String managerSwitchboardIp;
	private String exclusiveSwitchboardType;
	
	
	public String getManagerSwitchboardIp() {
		return managerSwitchboardIp;
	}
	public void setManagerSwitchboardIp(String managerSwitchboardIp) {
		this.managerSwitchboardIp = managerSwitchboardIp;
	}
	public String getExclusiveSwitchboardType() {
		return exclusiveSwitchboardType;
	}
	public void setExclusiveSwitchboardType(String exclusiveSwitchboardType) {
		this.exclusiveSwitchboardType = exclusiveSwitchboardType;
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
	public String getExclusiveSwitchboardIp() {
		return exclusiveSwitchboardIp;
	}
	public void setExclusiveSwitchboardIp(String exclusiveSwitchboardIp) {
		this.exclusiveSwitchboardIp = exclusiveSwitchboardIp;
	}
	public String getExclusiveSwitchboardPort() {
		return exclusiveSwitchboardPort;
	}
	public void setExclusiveSwitchboardPort(String exclusiveSwitchboardPort) {
		this.exclusiveSwitchboardPort = exclusiveSwitchboardPort;
	}
	public Integer getExclusiveSwitchboardOrder() {
		return exclusiveSwitchboardOrder;
	}
	public void setExclusiveSwitchboardOrder(Integer exclusiveSwitchboardOrder) {
		this.exclusiveSwitchboardOrder = exclusiveSwitchboardOrder;
	}
	public String getExclusiveSwitchboardNote() {
		return exclusiveSwitchboardNote;
	}
	public void setExclusiveSwitchboardNote(String exclusiveSwitchboardNote) {
		this.exclusiveSwitchboardNote = exclusiveSwitchboardNote;
	}
	@Override
	public String toString() {
		return "DevExclusiveSwitchboardInfo [exclusiveSwitchboardIp="
				+ exclusiveSwitchboardIp + ", exclusiveSwitchboardPort="
				+ exclusiveSwitchboardPort + ", exclusiveSwitchboardOrder="
				+ exclusiveSwitchboardOrder + ", exclusiveSwitchboardNote="
				+ exclusiveSwitchboardNote + ", telnetType=" + telnetType
				+ ", telnetUser=" + telnetUser + ", telnetPwd=" + telnetPwd
				+ ", telnetPort=" + telnetPort + "]";
	}
	 
	
}
