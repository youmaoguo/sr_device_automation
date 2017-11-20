package com.sunrun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ip网段分配情况
 * @author jl
 *
 */
public class DevIpSegmentDistributionBean extends BaseEntity implements Serializable { 
	private String 	ipSegment                  	;
	private String 	ip                	;
	private String 	subnetMask                 	;
	private String 	address                    	;
	private String 	networkType                	;
	private String 	useType                    	;
	private String 	devType                    	;
	private Integer 	usedIp                     	;
	private Integer 	leisureIp                  	;
	private String 	remark                     	;
	private String 	responsible                	;
	private String 	updateUserInfo             	;
	private Integer 	isLock                     	;
	
	
	public Integer getIsLock() {
		return isLock;
	}
	public void setIsLock(Integer isLock) {
		this.isLock = isLock;
	}
	/**修改时间*/
	private Date updateTime;
	
	private Integer isUseInteger;// ip 是否使用
	
	
	
	public Integer getIsUseInteger() {
		return isUseInteger;
	}
	public void setIsUseInteger(Integer isUseInteger) {
		this.isUseInteger = isUseInteger;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getUsedIp() {
		return usedIp;
	}
	public void setUsedIp(Integer usedIp) {
		this.usedIp = usedIp;
	}
	public Integer getLeisureIp() {
		return leisureIp;
	}
	public void setLeisureIp(Integer leisureIp) {
		this.leisureIp = leisureIp;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getIpSegment() {
		return ipSegment;
	}
	public void setIpSegment(String ipSegment) {
		this.ipSegment = ipSegment;
	}
	public String getSubnetMask() {
		return subnetMask;
	}
	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNetworkType() {
		return networkType;
	}
	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}
	public String getUseType() {
		return useType;
	}
	public void setUseType(String useType) {
		this.useType = useType;
	}
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	 
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getUpdateUserInfo() {
		return updateUserInfo;
	}
	public void setUpdateUserInfo(String updateUserInfo) {
		this.updateUserInfo = updateUserInfo;
	}
	
	
	
}
