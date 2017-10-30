package com.sunrun.entity;

import java.io.Serializable;

/**
 * 端口开通工单执行情况表
 * @author ymg
 *
 */
public class DevPortCommandInfo extends BaseEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	private String taskId;//外键，引用端口开通工单的id
	private String handlerName; //'处理人名称 '
	private String switchboardIp;// '交换机IP',
	private String portModeVlan ;//端口：Eth1/11,
	private String command;//'指令',
	private String method;//'指令对应方法名',
	//private Integer executeState;//指执行的状态 1 成功 2 失败 3 未提交
	private Integer executeState;//'执行状态 1:新建；2：执行中；3：执行成功； 4：执行失败'
	private String executeInfo;//'执行结果详情', 
	private Integer executeOrder;//'执行顺序', 
	
	private String createTime;
	private String createUser;
	private String updateTime;
	private String updateUser;
	
	public Integer getExecuteOrder() {
		return executeOrder;
	}
	public void setExecuteOrder(Integer executeOrder) {
		this.executeOrder = executeOrder;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public String getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHandlerName() {
		return handlerName;
	}
	public void setHandlerName(String handlerName) {
		this.handlerName = handlerName;
	}
	 
	public String getSwitchboardIp() {
		return switchboardIp;
	}
	public void setSwitchboardIp(String switchboardIp) {
		this.switchboardIp = switchboardIp;
	}
	public String getPortModeVlan() {
		return portModeVlan;
	}
	public void setPortModeVlan(String portModeVlan) {
		this.portModeVlan = portModeVlan;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Integer getExecuteState() {
		return executeState;
	}
	public void setExecuteState(Integer executeState) {
		this.executeState = executeState;
	}
	public String getExecuteInfo() {
		return executeInfo;
	}
	public void setExecuteInfo(String executeInfo) {
		this.executeInfo = executeInfo;
	}
	@Override
	public String toString() {
		return "DevPortCommandInfo [id=" + id + ", taskId=" + taskId
				+ ", handlerName=" + handlerName + ", switchboardIp="
				+ switchboardIp + ", portModeVlan=" + portModeVlan
				+ ", command=" + command + ", method=" + method
				+ ", executeState=" + executeState + ", executeInfo="
				+ executeInfo + ", executeOrder=" + executeOrder
				+ ", createTime=" + createTime + ", createUser=" + createUser
				+ ", updateTime=" + updateTime + ", updateUser=" + updateUser
				+ "]";
	}
	 
	 
	
}
