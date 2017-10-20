package com.sunrun.entity;



/**
 * ip网段管理属性信息
 * @author jl
 *
 */
public class DevIpSegmentConfigBean extends BaseEntity  { 
	private String 	networkType	;//	'网络类型',
	private String 	useType	;//	'用途',
	private String 	devType	;//	'设备类型',
	private String 	ipAddressType	;//	'ip地址类型：值有：BMC地址、管理IP、存储平面IP',
	private String 	userPlan	;//	'用途规划,如：SDN控制节点',
	private String 	category	;//	'类别，值为：机架服务器',
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
	public String getIpAddressType() {
		return ipAddressType;
	}
	public void setIpAddressType(String ipAddressType) {
		this.ipAddressType = ipAddressType;
	}
	public String getUserPlan() {
		return userPlan;
	}
	public void setUserPlan(String userPlan) {
		this.userPlan = userPlan;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
	
}
