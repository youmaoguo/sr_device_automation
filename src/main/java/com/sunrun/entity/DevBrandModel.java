package com.sunrun.entity;

import java.io.Serializable;

/**
 * 设备品牌型号对应表
 * @author ymg
 *
 */
public class DevBrandModel extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String brandName;	//'品牌名称',
	private String modelName;	//'型号',
	private String iosVersion;	//'IOS版本信息',
	private String iosVersion2;	//'备用字段',
	private String modelDescribe;
	private String showkvmDescribe;
	private String mainAccessPort;//接入交换机连接主汇聚端口
	private String backAccessPort;//接入交换机连接备汇聚端口
	
	public String getMainAccessPort() {
		return mainAccessPort;
	}
	public void setMainAccessPort(String mainAccessPort) {
		this.mainAccessPort = mainAccessPort;
	}
	public String getBackAccessPort() {
		return backAccessPort;
	}
	public void setBackAccessPort(String backAccessPort) {
		this.backAccessPort = backAccessPort;
	}
	public String getShowkvmDescribe() {
		return showkvmDescribe;
	}
	public void setShowkvmDescribe(String showkvmDescribe) {
		this.showkvmDescribe = showkvmDescribe;
	}
	public String getModelDescribe() {
		return modelDescribe;
	}
	public void setModelDescribe(String modelDescribe) {
		this.modelDescribe = modelDescribe;
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
	public String getIosVersion() {
		return iosVersion;
	}
	public void setIosVersion(String iosVersion) {
		this.iosVersion = iosVersion;
	}
	public String getIosVersion2() {
		return iosVersion2;
	}
	public void setIosVersion2(String iosVersion2) {
		this.iosVersion2 = iosVersion2;
	}
	@Override
	public String toString() {
		return "DevBrandModel [brandName=" + brandName + ", modelName="
				+ modelName + ", iosVersion=" + iosVersion + ", iosVersion2="
				+ iosVersion2 + ", modelDescribe=" + modelDescribe
				+ ", showkvmDescribe=" + showkvmDescribe + ", mainAccessPort="
				+ mainAccessPort + ", backAccessPort=" + backAccessPort + "]";
	}
	 
	
	
	
}
