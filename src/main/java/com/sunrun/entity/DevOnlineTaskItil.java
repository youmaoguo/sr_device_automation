package com.sunrun.entity;

/**
 * 设备上线批次任务与 itil对应实体类
 * @author ymg
 *
 */
public class DevOnlineTaskItil extends BaseEntity{

	private String itilNumber;		//'itil申请单编号 ',
	private String devOnlineTaskId;	// '设备上线任务表记录对应ID',
	public String getItilNumber() {
		return itilNumber;
	}
	public void setItilNumber(String itilNumber) {
		this.itilNumber = itilNumber;
	}
	public String getDevOnlineTaskId() {
		return devOnlineTaskId;
	}
	public void setDevOnlineTaskId(String devOnlineTaskId) {
		this.devOnlineTaskId = devOnlineTaskId;
	}
	@Override
	public String toString() {
		return "DevOnlineTaskItil [itilNumber=" + itilNumber
				+ ", devOnlineTaskId=" + devOnlineTaskId + "]";
	}
	
	
}
