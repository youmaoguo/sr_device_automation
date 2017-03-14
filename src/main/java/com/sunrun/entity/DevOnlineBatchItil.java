package com.sunrun.entity;

import java.util.Date;

/**
 * 设备上线批次itil工单表
 * @author ymg
 *
 */
public class DevOnlineBatchItil extends BaseEntity {
	
	private String batchName;		//'批次名称',
	private String batchDescribe;	//'批次描述',
	private int batchState;			//'批次状态 1：新建；2：执行中；3：完成;4:废除;5:失败',
	
	private String itilNumber;		//'itil申请单编号 文本，唯一键 151200319843 itil系统返回',
	//private String itilSourceId;  	//'来源ID GEN000002',
	private String itilAssignee;	//'处理人 文本00203045 必须为ITIL操作员账号，一般是员工号',
	private String itilCategory;	//' 类别 文本 流程管理',
	private String itilSubcategory;	//'子类别 文本 ITIL系统',
	private String itilBusinessArea;//'小类别 文本 其他',
	private String itilStatus;		//'状态 文本 待审批 系统自动生成，无需填写',
	private String itilRequestor;	//'申请人 文本 036131 联系人ID，一般为一事通ID',
	private String itilTitle;		//'标题 文本 评估体系平台系统请求',
	private String itilDescription;	//'申请内容',
	private Date itilPlannedEnd;	//'期望完成时间',
	//private Date itilRequestedDate; //'申请时间 日期时间 2015-12-07T14:02:07+00:00',
	//private String itilSource; 		//'来源 文本 cloud',
	//private String itilOpenedBy;	//'创建人 文本 cmb.int.cloud'
	
	
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
	@Override
	public String toString() {
		return "DevOnlineBatchItil [batchName=" + batchName
				+ ", batchDescribe=" + batchDescribe + ", batchState="
				+ batchState + ", itilNumber=" + itilNumber  + ", itilAssignee=" + itilAssignee
				+ ", itilCategory=" + itilCategory + ", itilSubcategory="
				+ itilSubcategory + ", itilBusinessArea=" + itilBusinessArea
				+ ", itilStatus=" + itilStatus + ", itilRequestor="
				+ itilRequestor + ", itilTitle=" + itilTitle
				+ ", itilDescription=" + itilDescription + ", itilPlannedEnd="
				+ itilPlannedEnd   + "]";
	}
	
	
}
