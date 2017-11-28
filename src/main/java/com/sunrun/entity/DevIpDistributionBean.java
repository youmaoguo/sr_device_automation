package com.sunrun.entity;

import java.util.Date;

/**
 * ip分配情况
 * @author jl
 *
 */
public class DevIpDistributionBean extends BaseEntity {
	private String 	newId	;
	private String 	address	;//	'地点',
	private String 	ip	;//	'ip地址：10.1.1.1',
	private String 	ipSegment	;//	'网段名称
	private String 	networkType	;//	'网络类型',
	private String 	useType	;//	'用途',

	private String 	vlan	;//	'vlan',
	private String 	subnetMask	;//	'子网掩码
	private String 	gateway	;//	'网关',

	private String 	remark	;//	'备注',
	private String 	responsible	;//	'责任人，格式为：0101311/张三',
	private String 	allocationUser	;//	'分配人，格式为：0101311/张三',
	private String 	allocationTime	;//	'分配时间',
	private String 	updateUserInfo	;//	'修改人，格式为：0101311/张三',
	private String isUse	;//	  是否使用  0 代表已未使用，1代表使用',
	private Integer isUseInteger	;//	  是否使用  0 代表已未使用，1代表使用',
	private String userId;
	private  String 	operationType;
	private  Integer 	operationTypeInteger;
	private String systemName;

	private Date updateTime;

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getIpSegment() {
		return ipSegment;
	}

	public void setIpSegment(String ipSegment) {
		this.ipSegment = ipSegment;
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

	public String getVlan() {
		return vlan;
	}

	public void setVlan(String vlan) {
		this.vlan = vlan;
	}

	public String getSubnetMask() {
		return subnetMask;
	}

	public void setSubnetMask(String subnetMask) {
		this.subnetMask = subnetMask;
	}

	public String getGateway() {
		return gateway;
	}

	public void setGateway(String gateway) {
		this.gateway = gateway;
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

	public String getAllocationUser() {
		return allocationUser;
	}

	public void setAllocationUser(String allocationUser) {
		this.allocationUser = allocationUser;
	}

	public String getAllocationTime() {
		return allocationTime;
	}

	public void setAllocationTime(String allocationTime) {
		this.allocationTime = allocationTime;
	}

	public String getUpdateUserInfo() {
		return updateUserInfo;
	}

	public void setUpdateUserInfo(String updateUserInfo) {
		this.updateUserInfo = updateUserInfo;
	}

	public String getIsUse() {
		return isUse;
	}

	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	public Integer getIsUseInteger() {
		return isUseInteger;
	}

	public void setIsUseInteger(Integer isUseInteger) {
		this.isUseInteger = isUseInteger;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public Integer getOperationTypeInteger() {
		return operationTypeInteger;
	}

	public void setOperationTypeInteger(Integer operationTypeInteger) {
		this.operationTypeInteger = operationTypeInteger;
	}
}
