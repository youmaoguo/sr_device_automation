package com.sunrun.entity;

/**
 * 区域汇聚交换机ip对应表
 * @author ymg
 *
 */
public class DevAreaSwitchboardIp extends BaseEntity {

	private String areaName;//区域名称',
	private String areaDescribe;//区域描述',
	private String mainSwitchboardIp;//'主汇聚交换机ip',
	private String backupSwitchboardIp;//'备汇聚交换机ip',
	
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
	@Override
	public String toString() {
		return "DevAreaSwitchboardIp [areaName=" + areaName + ", areaDescribe="
				+ areaDescribe + ", mainSwitchboardIp=" + mainSwitchboardIp
				+ ", backupSwitchboardIp=" + backupSwitchboardIp + "]";
	}
	
	
}
