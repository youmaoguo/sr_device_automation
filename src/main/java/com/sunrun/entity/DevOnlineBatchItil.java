package com.sunrun.entity;

import java.io.Serializable;

/**
 * 设备上线批次itil工单表
 * @author ymg
 *
 */
public class DevOnlineBatchItil extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String batchName;		//'批次名称',
	private String batchDescribe;	//'批次描述',
	private Integer batchState;			//'批次状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	
	private String itilNumber;		//'itil申请单编号 文本，唯一键 151200319843 itil系统返回',
	private String itilAssignee;	//'处理人 文本00203045 必须为ITIL操作员账号，一般是员工号',
	private String itilCategory;	//' 类别 文本 流程管理',
	private String itilSubcategory;	//'子类别 文本 ITIL系统',
	private String itilBusinessArea;//'小类别 文本 其他',
	private String itilStatus;		//'状态 文本系统自动生成，无需填写【登记》审批》实施》关闭】',
	private String itilRequestor;	//'申请人 文本 036131 联系人ID，一般为一事通ID',
	private String itilTitle;		//'标题 文本 评估体系平台系统请求',
	private String itilDescription;	//'申请内容',
	private String itilPlannedEnd;	//'期望完成时间',
	private String itilPlannedStart;	//'期望开始时间',
	
	public String getBatchName() {
		return batchName;
	}
	public String getItilPlannedStart() {
		return itilPlannedStart;
	}
	public void setItilPlannedStart(String itilPlannedStart) {
		this.itilPlannedStart = itilPlannedStart;
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
		return itilPlannedEnd;
	}
	public void setItilPlannedEnd(String itilPlannedEnd) {
		this.itilPlannedEnd = itilPlannedEnd;
	}
	@Override
	public String toString() {
		return "DevOnlineBatchItil [batchName=" + batchName
				+ ", batchDescribe=" + batchDescribe + ", batchState="
				+ batchState + ", itilNumber=" + itilNumber + ", itilAssignee="
				+ itilAssignee + ", itilCategory=" + itilCategory
				+ ", itilSubcategory=" + itilSubcategory
				+ ", itilBusinessArea=" + itilBusinessArea + ", itilStatus="
				+ itilStatus + ", itilRequestor=" + itilRequestor
				+ ", itilTitle=" + itilTitle + ", itilDescription="
				+ itilDescription + ", itilPlannedEnd=" + itilPlannedEnd
				+ ", itilPlannedStart=" + itilPlannedStart + "]";
	}
 
	
	
}
