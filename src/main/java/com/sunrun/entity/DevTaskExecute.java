package com.sunrun.entity;

import java.util.Date;

/**
 * 任务执行情况
 * @author ymg
 *
 */
public class DevTaskExecute extends BaseEntity {
	
	private String taskId;		//'任务id(引用表dev_online_task的id)',
	private int taskType;		//'任务类型，此字段目前不使用，备用',
	private int taskOrder;		//'任务执行顺序',
	private String taskDescribe;//'任务描述',
	private int taskExecuteState;//'任务执行状态 1：新建；2：执行中；3：成功;4:失败',
	private String taskExecuteNote;//'脚本执行情况',
	private Date taskExecuteBegin;//'任务开始执行时间',
	private Date taskExecuteEnd; //'任务执行完成时间',
	@Override
	public String toString() {
		return "DevTaskExecute [taskId=" + taskId + ", taskType=" + taskType
				+ ", taskOrder=" + taskOrder + ", taskDescribe=" + taskDescribe
				+ ", taskExecuteState=" + taskExecuteState
				+ ", taskExecuteNote=" + taskExecuteNote
				+ ", taskExecuteBegin=" + taskExecuteBegin
				+ ", taskExecuteEnd=" + taskExecuteEnd + "]";
	}
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public int getTaskType() {
		return taskType;
	}
	public void setTaskType(int taskType) {
		this.taskType = taskType;
	}
	public int getTaskOrder() {
		return taskOrder;
	}
	public void setTaskOrder(int taskOrder) {
		this.taskOrder = taskOrder;
	}
	public String getTaskDescribe() {
		return taskDescribe;
	}
	public void setTaskDescribe(String taskDescribe) {
		this.taskDescribe = taskDescribe;
	}
	public int getTaskExecuteState() {
		return taskExecuteState;
	}
	public void setTaskExecuteState(int taskExecuteState) {
		this.taskExecuteState = taskExecuteState;
	}
	public String getTaskExecuteNote() {
		return taskExecuteNote;
	}
	public void setTaskExecuteNote(String taskExecuteNote) {
		this.taskExecuteNote = taskExecuteNote;
	}
	public Date getTaskExecuteBegin() {
		return taskExecuteBegin;
	}
	public void setTaskExecuteBegin(Date taskExecuteBegin) {
		this.taskExecuteBegin = taskExecuteBegin;
	}
	public Date getTaskExecuteEnd() {
		return taskExecuteEnd;
	}
	public void setTaskExecuteEnd(Date taskExecuteEnd) {
		this.taskExecuteEnd = taskExecuteEnd;
	}
	
	
}
