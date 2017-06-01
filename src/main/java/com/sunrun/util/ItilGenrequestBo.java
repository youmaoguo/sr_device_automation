package com.sunrun.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

/**
 * 调用itit系统请求新建接口用到的请求对象
 * http://99.1.76.103:13080/SM/9/rest/genrequests 开发环境
 * http://10.1.248.21:13081/SM/9/rest/genrequests 生产
 * @author ymg
 *
 */
public class ItilGenrequestBo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String number;		//申请单编号,系统自动生成，无需填写
	private String sourceId;	//接口系统中对应工单的ID:GEN00002,
	private String assignee;	//处理人,必须为ITIL操作员账号，一般是员工号: 01034090,
	private String title;		//标题 ：评估体系平台系统发起新情求,
	private String category;	//类别: 流程管理,
	private String subcategory;	//子类别: ITIL系统,
	private String businessArea;//子类别: 其他,
	private String[] description;	//申请内容: [评估体系平台系统发起新情求,需求详细描述],
	private String requestor;	//申请人.联系人ID，一般为一事通ID :01034090,
	private String plannedEnd;	//期望完成时间: 2015-12-11T01;//00;//00+08;//00, //实际工单上显示北京时间为：2015/12/11 01;//00;//00
	private String openedBy;
	private String requestedDate;
	private String requestorName;
	private String source;
	private String status;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	public String[] getDescription() {
		return description;
	}
	public void setDescription(String[] description) {
		this.description = description;
	}
	public String getRequestor() {
		return requestor;
	}
	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}
	public String getOpenedBy() {
		return openedBy;
	}
	public void setOpenedBy(String openedBy) {
		this.openedBy = openedBy;
	}
	public String getPlannedEnd() {
		return plannedEnd;
	}
	public void setPlannedEnd(String plannedEnd) {
		this.plannedEnd = plannedEnd;
	}
	public String getRequestedDate() {
		return requestedDate;
	}
	public void setRequestedDate(String requestedDate) {
		this.requestedDate = requestedDate;
	}
	public String getRequestorName() {
		return requestorName;
	}
	public void setRequestorName(String requestorName) {
		this.requestorName = requestorName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ItilGenrequestBo [number=" + number + ", sourceId=" + sourceId
				+ ", assignee=" + assignee + ", title=" + title + ", category="
				+ category + ", subcategory=" + subcategory + ", businessArea="
				+ businessArea + ", description="
				+ Arrays.toString(description) + ", requestor=" + requestor
				+ ", plannedEnd=" + plannedEnd + ", openedBy=" + openedBy
				+ ", requestedDate=" + requestedDate + ", requestorName="
				+ requestorName + ", source=" + source + ", status=" + status
				+ "]";
	}
	
	
}
