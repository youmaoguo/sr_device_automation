package com.sunrun.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 设备端口开通工单实体
 * @author Administrator
 *
 */
public class DevPortDredgeOrder extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String handlerName;//'处理人名称 ',
	private String switchboardIp;//'交换机IP',
	private String portModeVlan;//'端口-模式-vlan 信息，格式为：Eth1/11-trunk-vlan190;Eth1/12-trunk-vlan192;',
	private Integer executeState;//'执行状态 1:新建；2：执行中；3：执行成功； 4：执行失败'
	
	private Date createTime;
	private String createUser;
	private Date updateTime;
	private String updateUser;
	
	@Override
	public String toString() {
		return "DevPortDredgeOrder [handlerName=" + handlerName + ", switchboardIp=" + switchboardIp + ", portModeVlan="
				+ portModeVlan + ", executeSstate=" + executeState + "]";
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
	public Integer getExecuteState() {
		return executeState;
	}
	public void setExecuteState(Integer executeState) {
		this.executeState = executeState;
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
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
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
	public String getUpdateUser() {
		return updateUser;
	}
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
}
