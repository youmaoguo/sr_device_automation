package com.sunrun.entity.view;

import java.util.Date;

/**
 * 查询批次、任务、执行情况的javaBean
 * @author ymg
 *
 */
public class DevOnlineBatchTaskView {
	
	private String id;				//批次itil ID
	private String batchName;		//'批次名称',
	private String batchDescribe;	//'批次描述',
	private int batchState;			//'批次状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	private String itilNumber;		//'itil申请单编号 文本，唯一键 151200319843 itil系统返回',
	private String itilSourceId;  	//'来源ID GEN000002',
	private String itilAssignee;	//'处理人 文本00203045 必须为ITIL操作员账号，一般是员工号',
	private String itilCategory;	//' 类别 文本 流程管理',
	private String itilSubcategory;	//'子类别 文本 ITIL系统',
	private String itilBusinessArea;//'小类别 文本 其他',
	private String itilStatus;		//'状态 文本 待审批 系统自动生成，无需填写',
	private String itilRequestor;	//'申请人 文本 036131 联系人ID，一般为一事通ID',
	private String itilTitle;		//'标题 文本 评估体系平台系统请求',
	private String itilDescription;	//'申请内容',
	private Date itilPlannedEnd;	//'期望完成时间',
	private Date itilRequestedDate; //'申请时间 日期时间 2015-12-07T14:02:07+00:00',
	private String itilSource; 		//'来源 文本 cloud',
	private String itilOpenedBy;	//'创建人 文本 cmb.int.cloud'
	
	private String taskId;			//任务id
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
	private Date taskCreateTime;		//任务创建时间
	private Date taskUpdateTime;		//任务修改时间
	
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getBatchName() {
		return batchName;
	}
	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}
	public String getBatchDescribe() {
		return batchDescribe;
	}
	public void setBatchDescribe(String batchDescribe) {
		this.batchDescribe = batchDescribe;
	}
	public int getBatchState() {
		return batchState;
	}
	public void setBatchState(int batchState) {
		this.batchState = batchState;
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
	public Date getTaskCreateTime() {
		return taskCreateTime;
	}
	public void setTaskCreateTime(Date taskCreateTime) {
		this.taskCreateTime = taskCreateTime;
	}
	public Date getTaskUpdateTime() {
		return taskUpdateTime;
	}
	public void setTaskUpdateTime(Date taskUpdateTime) {
		this.taskUpdateTime = taskUpdateTime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getItilNumber() {
		return itilNumber;
	}
	public void setItilNumber(String itilNumber) {
		this.itilNumber = itilNumber;
	}
	public String getItilAssignee() {
		return itilAssignee;
	}
	public void setItilAssignee(String itilAssignee) {
		this.itilAssignee = itilAssignee;
	}
	public String getItilCategory() {
		return itilCategory;
	}
	public void setItilCategory(String itilCategory) {
		this.itilCategory = itilCategory;
	}
	public String getItilSubcategory() {
		return itilSubcategory;
	}
	public void setItilSubcategory(String itilSubcategory) {
		this.itilSubcategory = itilSubcategory;
	}
	public String getItilBusinessArea() {
		return itilBusinessArea;
	}
	public void setItilBusinessArea(String itilBusinessArea) {
		this.itilBusinessArea = itilBusinessArea;
	}
	public String getItilStatus() {
		return itilStatus;
	}
	public void setItilStatus(String itilStatus) {
		this.itilStatus = itilStatus;
	}
	public String getItilRequestor() {
		return itilRequestor;
	}
	public void setItilRequestor(String itilRequestor) {
		this.itilRequestor = itilRequestor;
	}
	public String getItilTitle() {
		return itilTitle;
	}
	public void setItilTitle(String itilTitle) {
		this.itilTitle = itilTitle;
	}
	public String getItilDescription() {
		return itilDescription;
	}
	public void setItilDescription(String itilDescription) {
		this.itilDescription = itilDescription;
	}
	public Date getItilPlannedEnd() {
		return itilPlannedEnd;
	}
	public void setItilPlannedEnd(Date itilPlannedEnd) {
		this.itilPlannedEnd = itilPlannedEnd;
	}
	public String getItilSourceId() {
		return itilSourceId;
	}
	public void setItilSourceId(String itilSourceId) {
		this.itilSourceId = itilSourceId;
	}
	public Date getItilRequestedDate() {
		return itilRequestedDate;
	}
	public void setItilRequestedDate(Date itilRequestedDate) {
		this.itilRequestedDate = itilRequestedDate;
	}
	public String getItilSource() {
		return itilSource;
	}
	public void setItilSource(String itilSource) {
		this.itilSource = itilSource;
	}
	public String getItilOpenedBy() {
		return itilOpenedBy;
	}
	public void setItilOpenedBy(String itilOpenedBy) {
		this.itilOpenedBy = itilOpenedBy;
	}
	@Override
	public String toString() {
		return "DevOnlineBatchTaskView [id=" + id + ", batchName=" + batchName
				+ ", batchDescribe=" + batchDescribe + ", batchState="
				+ batchState + ", itilNumber=" + itilNumber + ", itilSourceId="
				+ itilSourceId + ", itilAssignee=" + itilAssignee
				+ ", itilCategory=" + itilCategory + ", itilSubcategory="
				+ itilSubcategory + ", itilBusinessArea=" + itilBusinessArea
				+ ", itilStatus=" + itilStatus + ", itilRequestor="
				+ itilRequestor + ", itilTitle=" + itilTitle
				+ ", itilDescription=" + itilDescription + ", itilPlannedEnd="
				+ itilPlannedEnd + ", itilRequestedDate=" + itilRequestedDate
				+ ", itilSource=" + itilSource + ", itilOpenedBy="
				+ itilOpenedBy + ", taskId=" + taskId + ", taskType="
				+ taskType + ", groupKey=" + groupKey + ", taskDescribe="
				+ taskDescribe + ", taskState=" + taskState + ", brandName="
				+ brandName + ", modelName=" + modelName + ", areaName="
				+ areaName + ", areaDescribe=" + areaDescribe + ", hostName="
				+ hostName + ", managerIp=" + managerIp
				+ ", mainSwitchboardIp=" + mainSwitchboardIp
				+ ", mainSwitchboardPort=" + mainSwitchboardPort
				+ ", backupSwitchboardIp=" + backupSwitchboardIp
				+ ", backupSwitchboardPort=" + backupSwitchboardPort
				+ ", devOnlineRack=" + devOnlineRack
				+ ", exclusiveSwitchboardIp=" + exclusiveSwitchboardIp
				+ ", exclusiveSwitchboardPort=" + exclusiveSwitchboardPort
				+ ", taskCreateTime=" + taskCreateTime + ", taskUpdateTime="
				+ taskUpdateTime + "]";
	}
	
	
}
