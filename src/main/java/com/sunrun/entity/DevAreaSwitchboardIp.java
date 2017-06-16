package com.sunrun.entity;

import java.io.Serializable;

/**
 * 区域汇聚交换机ip对应表
 * @author ymg
 *
 */
public class DevAreaSwitchboardIp extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String areaName;//区域名称',
	private String areaDescribe;//区域描述',
	private String mainSwitchboardIp;//'主汇聚交换机ip',
	private String backupSwitchboardIp;//'备汇聚交换机ip',
	
	private String subnet;//网段
	private String devName;//主设备名
	private String devType;//主设备类型
	private String devFactory;//主设备厂商
	private String telnetType;//主登陆协议
	private String telnetUser;//主登陆用户
	private String telnetPwd;//主登陆密码
	private String telnetPort;//主端口
	private String devHardwareType;//主硬件类型
	private String devManager;//主负责人
	private String backupDevName;//备设备名
	private String backupDevType;//备设备类型
	private String backupDevFactory;//备设备厂商
	private String backupTelnetType;//备登陆协议
	private String backupTelnetUser;//备登陆用户
	private String backupTelnetPwd;//备登陆密码
	private String backupTelnetPort;//备端口
	private String backupDevHardwareType;//备硬件类型
	private String backupDevManagers;//备负责人
	
	public String getTelnetPort() {
		return telnetPort;
	}
	public void setTelnetPort(String telnetPort) {
		this.telnetPort = telnetPort;
	}
	public String getBackupTelnetPort() {
		return backupTelnetPort;
	}
	public void setBackupTelnetPort(String backupTelnetPort) {
		this.backupTelnetPort = backupTelnetPort;
	}
	public String getAreaName() {
		return areaName;
	}
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}
	public String getAreaDescribe() {
		return areaDescribe;
	}
	public void setAreaDescribe(String areaDescribe) {
		this.areaDescribe = areaDescribe;
	}
	public String getMainSwitchboardIp() {
		return mainSwitchboardIp;
	}
	public void setMainSwitchboardIp(String mainSwitchboardIp) {
		this.mainSwitchboardIp = mainSwitchboardIp;
	}
	public String getBackupSwitchboardIp() {
		return backupSwitchboardIp;
	}
	public void setBackupSwitchboardIp(String backupSwitchboardIp) {
		this.backupSwitchboardIp = backupSwitchboardIp;
	}
	public String getSubnet() {
		return subnet;
	}
	public void setSubnet(String subnet) {
		this.subnet = subnet;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	public String getDevFactory() {
		return devFactory;
	}
	public void setDevFactory(String devFactory) {
		this.devFactory = devFactory;
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
	public String getDevHardwareType() {
		return devHardwareType;
	}
	public void setDevHardwareType(String devHardwareType) {
		this.devHardwareType = devHardwareType;
	}
	public String getDevManager() {
		return devManager;
	}
	public void setDevManager(String devManager) {
		this.devManager = devManager;
	}
	public String getBackupDevName() {
		return backupDevName;
	}
	public void setBackupDevName(String backupDevName) {
		this.backupDevName = backupDevName;
	}
	public String getBackupDevType() {
		return backupDevType;
	}
	public void setBackupDevType(String backupDevType) {
		this.backupDevType = backupDevType;
	}
	public String getBackupDevFactory() {
		return backupDevFactory;
	}
	public void setBackupDevFactory(String backupDevFactory) {
		this.backupDevFactory = backupDevFactory;
	}
	public String getBackupTelnetType() {
		return backupTelnetType;
	}
	public void setBackupTelnetType(String backupTelnetType) {
		this.backupTelnetType = backupTelnetType;
	}
	public String getBackupTelnetUser() {
		return backupTelnetUser;
	}
	public void setBackupTelnetUser(String backupTelnetUser) {
		this.backupTelnetUser = backupTelnetUser;
	}
	public String getBackupTelnetPwd() {
		return backupTelnetPwd;
	}
	public void setBackupTelnetPwd(String backupTelnetPwd) {
		this.backupTelnetPwd = backupTelnetPwd;
	}
	public String getBackupDevHardwareType() {
		return backupDevHardwareType;
	}
	public void setBackupDevHardwareType(String backupDevHardwareType) {
		this.backupDevHardwareType = backupDevHardwareType;
	}
	public String getBackupDevManagers() {
		return backupDevManagers;
	}
	public void setBackupDevManagers(String backupDevManagers) {
		this.backupDevManagers = backupDevManagers;
	}
	@Override
	public String toString() {
		return "DevAreaSwitchboardIp [areaName=" + areaName + ", areaDescribe="
				+ areaDescribe + ", mainSwitchboardIp=" + mainSwitchboardIp
				+ ", backupSwitchboardIp=" + backupSwitchboardIp + ", subnet="
				+ subnet + ", devName=" + devName + ", devType=" + devType
				+ ", devFactory=" + devFactory + ", telnetType=" + telnetType
				+ ", telnetUser=" + telnetUser + ", telnetPwd=" + telnetPwd
				+ ", telnetPort=" + telnetPort + ", devHardwareType="
				+ devHardwareType + ", devManager=" + devManager
				+ ", backupDevName=" + backupDevName + ", backupDevType="
				+ backupDevType + ", backupDevFactory=" + backupDevFactory
				+ ", backupTelnetType=" + backupTelnetType
				+ ", backupTelnetUser=" + backupTelnetUser
				+ ", backupTelnetPwd=" + backupTelnetPwd
				+ ", backupTelnetPort=" + backupTelnetPort
				+ ", backupDevHardwareType=" + backupDevHardwareType
				+ ", backupDevManagers=" + backupDevManagers + "]";
	}
	
	
	
}
