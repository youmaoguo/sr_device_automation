package com.sunrun.entity;

/**
 * 设备上线批次任务
 * @author ymg
 *
 */
public class DevOnlineTask extends BaseEntity {
	
	private String batchId;			//'批次id(引用表dev_online_batch的主键)',
	private int taskType; 			//'任务类型 1：接入设备任务;2:汇聚设备任务',
	private String groupKey;		//'组名，用于标示多个任务属于同一组',
	private String taskDescribe;	//'任务描述',
	private int taskState;			//'批次任务状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	private String brandName;		//'品牌名称',
	private String modelName;		//'型号',
	private String areaName;		//'区域名称',
	private String areaDescribe;	//'区域描述',
	private String hostName;		//'接入交换机hostname',
	private String managerIp;		//'接入交换机管理IP',
	private String mainSwitchboardIp;//'主汇聚交换机ip',
	private String mainSwitchboardPort;//'主汇聚交换机端口',
	private String backupSwitchboardIp;//'备汇聚交换机ip',
	private String backupSwitchboardPort;//'备汇聚交换机端口',
	private String devOnlineRack;		//'上线后所处机架位置描述',
	private String exclusiveSwitchboardIp;//'带外交机ip',
	private String exclusiveSwitchboardPort;//'带外交机端口',
	
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
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	public String getGroupKey() {
		return groupKey;
	}
	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
	public String getBatchId() {
		return batchId;
	}
	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}
	public String getTaskDescribe() {
		return taskDescribe;
	}
	public void setTaskDescribe(String taskDescribe) {
		this.taskDescribe = taskDescribe;
	}
	public int getTaskState() {
		return taskState;
	}
	public void setTaskState(int taskState) {
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
		return "DevOnlineTask [batchId=" + batchId + ", taskType=" + taskType
				+ ", groupKey=" + groupKey + ", taskDescribe=" + taskDescribe
				+ ", taskState=" + taskState + ", brandName=" + brandName
				+ ", modelName=" + modelName + ", areaName=" + areaName
				+ ", areaDescribe=" + areaDescribe + ", hostName=" + hostName
				+ ", managerIp=" + managerIp + ", mainSwitchboardIp="
				+ mainSwitchboardIp + ", mainSwitchboardPort="
				+ mainSwitchboardPort + ", backupSwitchboardIp="
				+ backupSwitchboardIp + ", backupSwitchboardPort="
				+ backupSwitchboardPort + ", devOnlineRack=" + devOnlineRack
				+ ", exclusiveSwitchboardIp=" + exclusiveSwitchboardIp
				+ ", exclusiveSwitchboardPort=" + exclusiveSwitchboardPort
				+ "]";
	}
	

	
	
	
}
