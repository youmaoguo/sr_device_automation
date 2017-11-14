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
	private String 	devType	;//	'设备类型',
	private String 	category	;//	'类别，值为：机架服务器',
	private String 	ipAddressType	;//	'ip地址类型：值有：BMC地址、管理IP、存储平面IP',
	private String 	devName	;//	'设备名称：如：XL8RD14U02_BD1_128A',
	private String 	devModel	;//	'设备型号：如：RH2288H
	private String 	userPlan	;//	'用途规划,如：SDN控制节点',
	private String 	vlan	;//	'vlan',
	private String 	subnetMask	;//	'子网掩码
	private String 	gateway	;//	'网关',
	private String 	area	;//	'区域，如：核心-接入1',
	private String 	startNode	;//	'始节点，如：XL8RD14U02_BD1_128A',
	private String 	endNode	;//	'终节点，如：XL8RD14U02_BD1_128B',
	private String 	startPort	;//	'始端口，如：Q1/0/1',
	private String 	endPort	;//	'终端口，如：Q1/0/2',
	private String 	remark	;//	'备注',
	private String 	responsible	;//	'责任人，格式为：0101311/张三',
	private String 	allocationUser	;//	'分配人，格式为：0101311/张三',
	private String 	allocationTime	;//	'分配时间',
	private String 	updateUserInfo	;//	'修改人，格式为：0101311/张三',
	private String isUse	;//	  是否使用  0 代表已未使用，1代表使用',
	private Integer isUseInteger	;//	  是否使用  0 代表已未使用，1代表使用',
	private String userId;



	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getIsUseInteger() {
		return isUseInteger;
	}
	public void setIsUseInteger(Integer isUseInteger) {
		this.isUseInteger = isUseInteger;
	}
	/**修改时间*/
	private Date updateTime;


	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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
	public String getDevType() {
		return devType;
	}
	public void setDevType(String devType) {
		this.devType = devType;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getIpAddressType() {
		return ipAddressType;
	}
	public void setIpAddressType(String ipAddressType) {
		this.ipAddressType = ipAddressType;
	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevModel() {
		return devModel;
	}
	public void setDevModel(String devModel) {
		this.devModel = devModel;
	}
	public String getUserPlan() {
		return userPlan;
	}
	public void setUserPlan(String userPlan) {
		this.userPlan = userPlan;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getStartNode() {
		return startNode;
	}
	public void setStartNode(String startNode) {
		this.startNode = startNode;
	}
	public String getEndNode() {
		return endNode;
	}
	public void setEndNode(String endNode) {
		this.endNode = endNode;
	}
	public String getStartPort() {
		return startPort;
	}
	public void setStartPort(String startPort) {
		this.startPort = startPort;
	}
	public String getEndPort() {
		return endPort;
	}
	public void setEndPort(String endPort) {
		this.endPort = endPort;
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



}
