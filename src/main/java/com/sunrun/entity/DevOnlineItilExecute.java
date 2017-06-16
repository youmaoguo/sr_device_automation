package com.sunrun.entity;

import java.io.Serializable;

/**
 * 设备上线批次_itil工单执行情况实体类
 * @author ymg
 *
 */
public class DevOnlineItilExecute extends DevOnlineBatchItil implements Serializable{

	private static final long serialVersionUID = 1L;
	private String itilSourceId;  	//'来源ID GEN000002',
	private String itilRequestedDate; //'申请时间 日期时间 2015-12-07T14:02:07+00:00',
	private String itilSource; 		//'来源 文本 cloud',
	private String itilOpenedBy;	//'创建人 文本 cmb.int.cloud'
	
	public String getItilSourceId() {
		return itilSourceId;
	}
	public void setItilSourceId(String itilSourceId) {
		this.itilSourceId = itilSourceId;
	}
	public String getItilRequestedDate() {
		/*SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = "";
		if(itilRequestedDate!=null){
			s = fmt.format(itilRequestedDate);
		}
		return s;*/
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
	@Override
	public String toString() {
		return "DevOnlineItilExecute [itilSourceId=" + itilSourceId
				+ ", itilRequestedDate=" + itilRequestedDate + ", itilSource="
				+ itilSource + ", itilOpenedBy=" + itilOpenedBy + "]";
	}
	
}
