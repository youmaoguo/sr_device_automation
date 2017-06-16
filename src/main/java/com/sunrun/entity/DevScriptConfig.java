package com.sunrun.entity;

import java.io.Serializable;

/**
 * 设备脚本配制信息
 * @author ymg
 *
 */
public class DevScriptConfig extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	private String objectId;	//'其他表对象Id',
	private Integer devType;	// '设备类型：1、接入交换机； 2 、主汇聚交换机； 3 、备汇聚交换机',
	private Integer scriptType; //'脚本类型: 1配制文件',
	private Integer scriptOrder;//'脚本顺序',
	private String scriptInfo;	//'脚本内容',
	
	@Override
	public String toString() {
		return "DevScriptConfig [objectId=" + objectId + ", devType=" + devType
				+ ", scriptType=" + scriptType + ", scriptOrder=" + scriptOrder
				+ ", scriptInfo=" + scriptInfo + "]";
	}
	public String getObjectId() {
		return objectId;
	}
	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	public Integer getDevType() {
		return devType;
	}
	public void setDevType(Integer devType) {
		this.devType = devType;
	}
	public Integer getScriptType() {
		return scriptType;
	}
	public void setScriptType(Integer scriptType) {
		this.scriptType = scriptType;
	}
	public Integer getScriptOrder() {
		return scriptOrder;
	}
	public void setScriptOrder(Integer scriptOrder) {
		this.scriptOrder = scriptOrder;
	}
	public String getScriptInfo() {
		return scriptInfo;
	}
	public void setScriptInfo(String scriptInfo) {
		this.scriptInfo = scriptInfo;
	}
	
	
	
}
