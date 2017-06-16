package com.sunrun.entity;

import java.io.Serializable;

/**
 * 带外交换机连接信息
 * @author ymg
 *
 */

public class DevExclusiveSwitchboardConn extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	private String exclusiveSwitchboardInfo;	//'带外交机要信息描述',
	private String exclusiveSwitchboardIp;		//'带外交机ip',
	private String exclusiveSwitchboardPort;	//'带外交机端口',
	private String brandName;					//'品牌名称',
	private String modelName;					//'型号',
	private String currentIosVersion;			//'当前IOS版本信息',
	private Integer exclusiveSwitchboardOrder;//'带外交机顺序',
	
	public Integer getExclusiveSwitchboardOrder() {
		return exclusiveSwitchboardOrder;
	}
	public void setExclusiveSwitchboardOrder(Integer exclusiveSwitchboardOrder) {
		this.exclusiveSwitchboardOrder = exclusiveSwitchboardOrder;
	}
	public String getExclusiveSwitchboardInfo() {
		return exclusiveSwitchboardInfo;
	}
	public void setExclusiveSwitchboardInfo(String exclusiveSwitchboardInfo) {
		this.exclusiveSwitchboardInfo = exclusiveSwitchboardInfo;
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
	public String getCurrentIosVersion() {
		return currentIosVersion;
	}
	public void setCurrentIosVersion(String currentIosVersion) {
		this.currentIosVersion = currentIosVersion;
	}
	@Override
	public String toString() {
		return "DevExclusiveSwitchboardConn [exclusiveSwitchboardInfo="
				+ exclusiveSwitchboardInfo + ", exclusiveSwitchboardIp="
				+ exclusiveSwitchboardIp + ", exclusiveSwitchboardPort="
				+ exclusiveSwitchboardPort + ", brandName=" + brandName
				+ ", modelName=" + modelName + ", currentIosVersion="
				+ currentIosVersion + ", exclusiveSwitchboardOrder="
				+ exclusiveSwitchboardOrder + "]";
	}
	 
}
