package com.sunrun.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ip网段分配情况
 * @author jl
 *
 */
public class DevIpSegmentDistributionBean extends BaseEntity implements Serializable {
	public String 	ipSegment                  	;
	public String 	ip                	;
	public String 	subnetMask                 	;
	public String 	address                    	;
	public String 	networkType                	;
	public String 	useType                    	;
	public Integer 	usedIp                     	;
	public Integer 	allIp                  	;
	public String 	remark                     	;
	public String 	responsible                	;
	public String 	updateUserInfo             	;
	public String 	vlan             	;
	public String 	gateway             	;
	public Integer 	campOn             	;
	public String 	operationType;
	public Integer	operationTypeInteger;

	public Integer getOperationTypeInteger() {
		return operationTypeInteger;
	}

	public void setOperationTypeInteger(Integer operationTypeInteger) {
		this.operationTypeInteger = operationTypeInteger;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Integer getAllIp() {
		return allIp;
	}

	public void setAllIp(Integer allIp) {
		this.allIp = allIp;
	}

	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	public Integer getCampOn() {
		return campOn;
	}

	public void setCampOn(Integer campOn) {
		this.campOn = campOn;
	}

	/**修改时间*/
	public Date updateTime;

	public Integer isUseInteger;// ip 是否使用
	
	
	
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
		return allIp;
	}
	public void setLeisureIp(Integer allIp) {
		this.allIp = allIp;
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
