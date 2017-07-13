package com.sunrun.entity.view;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 查询批次、任务、执行情况的javaBean
 * @author ymg
 *
 */
public class DevOnlineBatchTaskView {
	
	//private String id;				//批次itil ID
	private String batchName;		//'批次名称',
	private String batchDescribe;	//'批次描述',
	private Integer batchState;			//'批次状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
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
	private Date itilPlannedStart;	//'期望开始时间',
	private String itilRequestedDate; //'申请时间 日期时间 2015-12-07T14:02:07+00:00',
	private String itilSource; 		//'来源 文本 cloud',
	private String itilOpenedBy;	//'创建人 文本 cmb.int.cloud'
	
	private String id;					//任务id
	private Integer taskType; 			//'任务类型 1：接入设备任务;2:汇聚设备任务',
	private String groupKey;		//'组名，用于标示多个任务属于同一组',
	private String taskDescribe;	//'任务描述',
	private Integer taskState;			//'批次任务状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	private String brandName;		//'品牌名称',
	private String modelName;		//'型号',
	private String areaName;		//'区域名称',
	private String areaDescribe;	//'区域描述',
	private String hostName;		//'接入交换机hostname',
	private String managerIp;		//'接入交换机管理IP',
	private String vlan;			//接入交换机将要上到哪个VLAN上
	private String mainSwitchboardIp;//'主汇聚交换机ip',
	private String mainSwitchboardPort;//'主汇聚交换机端口',
	private String backupSwitchboardIp;//'备汇聚交换机ip',
	private String backupSwitchboardPort;//'备汇聚交换机端口',
	private String devOnlineRack;		//'上线后所处机架位置描述',
	private String exclusiveSwitchboardIp;//'带外交机ip',
	private String exclusiveSwitchboardPort;//'带外交机端口',
	private Date createTime;		//任务创建时间
	private Date updateTime;		//任务修改时间
	private String createUser;
	private Integer managerIpWrite;		//接入交换机管理口ip写入配制状态 ；0 ：待写入，1：成功,2:失败
	private Integer accessConfigWrite;	//接入交换机写入配制状态 ；0 ：待写入，1：成功,2:失败
	private String exclusiveSwitchboardInfo;//带外交机要信息描述
	private String currentIosVersion;	//当前IOS版本信息
	private Integer mainSwitchboardConfigWrite;//主汇聚交换机写入配制状态 ；0 ：待写入，1：成功,2:失败
	private String modelIosVersion;		//型号最新IOS版本
	private Integer accessVersionWrite;//接入交换机IOS版本更新状态 ；0 ：待更新，1：成功,2:失败;3:无需更新
	private Integer switchState;//设备添加状态 1：设备准备；2：汇聚设备配制；3：异常工单;4:成功工单 
	private Integer backupSwitchboardConfigWrite;//备汇聚交换机写入配制状态 ；0 ：待写入，1：成功,2:失败
	private String emailId;//发送邮件id(sys_send_email表)
	private String userName;
	
	private Integer accessSwitchboardCheck;//接入交换机校验状态 ；0 ：待校验，1：校验成功,2:校验失败
	private String accessSwitchboardCheckInfo;//接入交换机校验信息
	private String taskCurrentStepDescribe;//工单任务执行步骤描述
	
	private Integer taskAllStep;
	private Integer executeStep;		//任务步骤
	private Integer taskCurrentStep;	//任务步骤
	
	public String getItilPlannedStart() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = "";
		if(itilPlannedStart!=null){
			s = fmt.format(itilPlannedStart);
		}
		return s;
	}
	public void setItilPlannedStart(Date itilPlannedStart) {
		this.itilPlannedStart = itilPlannedStart;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getTaskAllStep() {
		return taskAllStep;
	}
	public void setTaskAllStep(Integer taskAllStep) {
		this.taskAllStep = taskAllStep;
	}
	public String getCreateTime() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = "";
		if(createTime!=null){
			s = fmt.format(createTime);
		}
		return s;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateTime() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = "";
		if(updateTime!=null){
			s = fmt.format(updateTime);
		}
		return s;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public Integer getAccessSwitchboardCheck() {
		return accessSwitchboardCheck;
	}
	public void setAccessSwitchboardCheck(Integer accessSwitchboardCheck) {
		this.accessSwitchboardCheck = accessSwitchboardCheck;
	}
	public String getAccessSwitchboardCheckInfo() {
		return accessSwitchboardCheckInfo;
	}
	public void setAccessSwitchboardCheckInfo(String accessSwitchboardCheckInfo) {
		this.accessSwitchboardCheckInfo = accessSwitchboardCheckInfo;
	}
	public String getTaskCurrentStepDescribe() {
		return taskCurrentStepDescribe;
	}
	public void setTaskCurrentStepDescribe(String taskCurrentStepDescribe) {
		this.taskCurrentStepDescribe = taskCurrentStepDescribe;
	}
	public Integer getTaskCurrentStep() {
		return taskCurrentStep;
	}
	public void setTaskCurrentStep(Integer taskCurrentStep) {
		this.taskCurrentStep = taskCurrentStep;
	}
	public Integer getSwitchState() {
		return switchState;
	}
	public void setSwitchState(Integer switchState) {
		this.switchState = switchState;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getBackupSwitchboardConfigWrite() {
		return backupSwitchboardConfigWrite;
	}
	public void setBackupSwitchboardConfigWrite(Integer backupSwitchboardConfigWrite) {
		this.backupSwitchboardConfigWrite = backupSwitchboardConfigWrite;
	}
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
	public Integer getMainSwitchboardConfigWrite() {
		return mainSwitchboardConfigWrite;
	}
	public void setMainSwitchboardConfigWrite(Integer mainSwitchboardConfigWrite) {
		this.mainSwitchboardConfigWrite = mainSwitchboardConfigWrite;
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
	public String getVlan() {
		return vlan;
	}
	public void setVlan(String vlan) {
		this.vlan = vlan;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public Integer getBatchState() {
		return batchState;
	}
	public void setBatchState(Integer batchState) {
		this.batchState = batchState;
	}
	public String getItilNumber() {
		return itilNumber;
	}
	public void setItilNumber(String itilNumber) {
		this.itilNumber = itilNumber;
	}
	public String getItilSourceId() {
		return itilSourceId;
	}
	public void setItilSourceId(String itilSourceId) {
		this.itilSourceId = itilSourceId;
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
	public String getItilPlannedEnd() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = "";
		if(itilPlannedEnd!=null){
			s = fmt.format(itilPlannedEnd);
		}
		return s;
	}
	public void setItilPlannedEnd(Date itilPlannedEnd) {
		this.itilPlannedEnd = itilPlannedEnd;
	}
	public String getItilRequestedDate() {
		return itilRequestedDate;
	}
	public void setItilRequestedDate(String itilRequestedDate) {
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
	
	public Integer getExecuteStep() {
		return executeStep;
	}
	public void setExecuteStep(Integer executeStep) {
		this.executeStep = executeStep;
	}
	
	public String getModelIosVersion() {
		return modelIosVersion;
	}
	public void setModelIosVersion(String modelIosVersion) {
		this.modelIosVersion = modelIosVersion;
	}
	public Integer getAccessVersionWrite() {
		return accessVersionWrite;
	}
	public void setAccessVersionWrite(Integer accessVersionWrite) {
		this.accessVersionWrite = accessVersionWrite;
	}
	@Override
	public String toString() {
		return "DevOnlineBatchTaskView [batchName=" + batchName
				+ ", batchDescribe=" + batchDescribe + ", batchState="
				+ batchState + ", itilNumber=" + itilNumber + ", itilSourceId="
				+ itilSourceId + ", itilAssignee=" + itilAssignee
				+ ", itilCategory=" + itilCategory + ", itilSubcategory="
				+ itilSubcategory + ", itilBusinessArea=" + itilBusinessArea
				+ ", itilStatus=" + itilStatus + ", itilRequestor="
				+ itilRequestor + ", itilTitle=" + itilTitle
				+ ", itilDescription=" + itilDescription + ", itilPlannedEnd="
				+ itilPlannedEnd + ", itilPlannedStart=" + itilPlannedStart
				+ ", itilRequestedDate=" + itilRequestedDate + ", itilSource="
				+ itilSource + ", itilOpenedBy=" + itilOpenedBy + ", id=" + id
				+ ", taskType=" + taskType + ", groupKey=" + groupKey
				+ ", taskDescribe=" + taskDescribe + ", taskState=" + taskState
				+ ", brandName=" + brandName + ", modelName=" + modelName
				+ ", areaName=" + areaName + ", areaDescribe=" + areaDescribe
				+ ", hostName=" + hostName + ", managerIp=" + managerIp
				+ ", vlan=" + vlan + ", mainSwitchboardIp=" + mainSwitchboardIp
				+ ", mainSwitchboardPort=" + mainSwitchboardPort
				+ ", backupSwitchboardIp=" + backupSwitchboardIp
				+ ", backupSwitchboardPort=" + backupSwitchboardPort
				+ ", devOnlineRack=" + devOnlineRack
				+ ", exclusiveSwitchboardIp=" + exclusiveSwitchboardIp
				+ ", exclusiveSwitchboardPort=" + exclusiveSwitchboardPort
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", createUser=" + createUser + ", managerIpWrite="
				+ managerIpWrite + ", accessConfigWrite=" + accessConfigWrite
				+ ", exclusiveSwitchboardInfo=" + exclusiveSwitchboardInfo
				+ ", currentIosVersion=" + currentIosVersion
				+ ", mainSwitchboardConfigWrite=" + mainSwitchboardConfigWrite
				+ ", modelIosVersion=" + modelIosVersion
				+ ", accessVersionWrite=" + accessVersionWrite
				+ ", switchState=" + switchState
				+ ", backupSwitchboardConfigWrite="
				+ backupSwitchboardConfigWrite + ", emailId=" + emailId
				+ ", userName=" + userName + ", accessSwitchboardCheck="
				+ accessSwitchboardCheck + ", accessSwitchboardCheckInfo="
				+ accessSwitchboardCheckInfo + ", taskCurrentStepDescribe="
				+ taskCurrentStepDescribe + ", taskAllStep=" + taskAllStep
				+ ", executeStep=" + executeStep + ", taskCurrentStep="
				+ taskCurrentStep + "]";
	}
	 
	
	 
	
}
