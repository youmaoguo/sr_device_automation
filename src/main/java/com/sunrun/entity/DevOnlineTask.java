package com.sunrun.entity;

/**
 * 设备上线批次任务
 * @author ymg
 *
 */
public class DevOnlineTask extends BaseEntity {
	
	private Integer taskType; 			//'任务类型 1：接入设备任务;2:汇聚设备任务',
	private String groupKey;		//'组名，用于标示多个任务属于同一组',
	private String taskDescribe;	//'任务描述',
	private Integer taskState;			//'批次任务状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	private String brandName;		//'品牌名称',
	private String modelName;		//'型号',
	private String areaName;		//'区域名称',
	private String areaDescribe;	//'区域描述',
	private String hostName;		//'接入交换机hostname',
	private String vlan;			//'接入交换机将要上到哪个VLAN上',
	private String managerIp;		//'接入交换机管理IP',
	private String mainSwitchboardIp;//'主汇聚交换机ip',
	private String mainSwitchboardPort;//'主汇聚交换机端口',
	private String backupSwitchboardIp;//'备汇聚交换机ip',
	private String backupSwitchboardPort;//'备汇聚交换机端口',
	private String devOnlineRack;		//'上线后所处机架位置描述',
	private String exclusiveSwitchboardIp;//'带外交机ip',
	private String exclusiveSwitchboardPort;//'带外交机端口',
	
	private Integer managerIpWrite;		//接入交换机写入配制状态 ；0 ：待写入，1：成功,2:失败
	private Integer accessConfigWrite;	//接入交换机写入配制状态 ；0 ：待写入，1：成功,2:失败
	private String exclusiveSwitchboardInfo;//带外交机要信息描述
	private String currentIosVersion;	//当前IOS版本信息
	private Integer mainSwitchboardConfigWrite;//主汇聚交换机写入配制状态 ；0 ：待写入，1：成功,2:失败
	
	
	public Integer getManagerIpWrite() {
		return managerIpWrite;
	}
	public void setManagerIpWrite(Integer managerIpWrite) {
		this.managerIpWrite = managerIpWrite;
	}
	public Integer getAccessConfigWrite() {
		return accessConfigWrite;
	}
	public void setAccessConfigWrite(Integer accessConfigWrite) {
		this.accessConfigWrite = accessConfigWrite;
	}
	public String getExclusiveSwitchboardInfo() {
		return exclusiveSwitchboardInfo;
	}
	public void setExclusiveSwitchboardInfo(String exclusiveSwitchboardInfo) {
		this.exclusiveSwitchboardInfo = exclusiveSwitchboardInfo;
	}
	public String getCurrentIosVersion() {
		return currentIosVersion;
	}
	public void setCurrentIosVersion(String currentIosVersion) {
		this.currentIosVersion = currentIosVersion;
	}
	public Integer getMainSwitchboardConfigWrite() {
		return mainSwitchboardConfigWrite;
	}
	public void setMainSwitchboardConfigWrite(Integer mainSwitchboardConfigWrite) {
		this.mainSwitchboardConfigWrite = mainSwitchboardConfigWrite;
	}
	public String getVlan() {
		return vlan;
	}
	public void setVlan(String vlan) {
		this.vlan = vlan;
	}
	public Integer getTaskType() {
		return taskType;
	}
	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}
	public String getGroupKey() {
		return groupKey;
	}
	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
	public String getTaskDescribe() {
		return taskDescribe;
	}
	public void setTaskDescribe(String taskDescribe) {
		this.taskDescribe = taskDescribe;
	}
	public Integer getTaskState() {
		return taskState;
	}
	public void setTaskState(Integer taskState) {
		this.taskState = taskState;
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
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getManagerIp() {
		return managerIp;
	}
	public void setManagerIp(String managerIp) {
		this.managerIp = managerIp;
	}
	public String getMainSwitchboardIp() {
		return mainSwitchboardIp;
	}
	public void setMainSwitchboardIp(String mainSwitchboardIp) {
		this.mainSwitchboardIp = mainSwitchboardIp;
	}
	public String getMainSwitchboardPort() {
		return mainSwitchboardPort;
	}
	public void setMainSwitchboardPort(String mainSwitchboardPort) {
		this.mainSwitchboardPort = mainSwitchboardPort;
	}
	public String getBackupSwitchboardIp() {
		return backupSwitchboardIp;
	}
	public void setBackupSwitchboardIp(String backupSwitchboardIp) {
		this.backupSwitchboardIp = backupSwitchboardIp;
	}
	public String getBackupSwitchboardPort() {
		return backupSwitchboardPort;
	}
	public void setBackupSwitchboardPort(String backupSwitchboardPort) {
		this.backupSwitchboardPort = backupSwitchboardPort;
	}
	public String getDevOnlineRack() {
		return devOnlineRack;
	}
	public void setDevOnlineRack(String devOnlineRack) {
		this.devOnlineRack = devOnlineRack;
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
	@Override
	public String toString() {
		return "DevOnlineTask [taskType=" + taskType
				+ ", groupKey=" + groupKey + ", taskDescribe=" + taskDescribe
				+ ", taskState=" + taskState + ", brandName=" + brandName
				+ ", modelName=" + modelName + ", areaName=" + areaName
				+ ", areaDescribe=" + areaDescribe + ", hostName=" + hostName
				+ ", vlan=" + vlan + ", managerIp=" + managerIp
				+ ", mainSwitchboardIp=" + mainSwitchboardIp
				+ ", mainSwitchboardPort=" + mainSwitchboardPort
				+ ", backupSwitchboardIp=" + backupSwitchboardIp
				+ ", backupSwitchboardPort=" + backupSwitchboardPort
				+ ", devOnlineRack=" + devOnlineRack
				+ ", exclusiveSwitchboardIp=" + exclusiveSwitchboardIp
				+ ", exclusiveSwitchboardPort=" + exclusiveSwitchboardPort
				+ ", managerIpWrite=" + managerIpWrite + ", accessConfigWrite="
				+ accessConfigWrite + ", exclusiveSwitchboardInfo="
				+ exclusiveSwitchboardInfo + ", currentIosVersion="
				+ currentIosVersion + ", mainSwitchboardConfigWrite="
				+ mainSwitchboardConfigWrite + "]";
	}
	
	
	
	
}
