package com.sunrun.entity;

/**
 * 带外交换机信息
 * @author ymg
 *
 */
public class DevExclusiveSwitchboardInfo extends BaseEntity {

	private String exclusiveSwitchboardIp;	//'带外交机ip',
	private String exclusiveSwitchboardPort;//'带外交机端口',
	private Integer exclusiveSwitchboardOrder;//'带外交机顺序',
	private String exclusiveSwitchboardNote;//'带外交机要信息备注',
	
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
	public Integer getExclusiveSwitchboardOrder() {
		return exclusiveSwitchboardOrder;
	}
	public void setExclusiveSwitchboardOrder(Integer exclusiveSwitchboardOrder) {
		this.exclusiveSwitchboardOrder = exclusiveSwitchboardOrder;
	}
	public String getExclusiveSwitchboardNote() {
		return exclusiveSwitchboardNote;
	}
	public void setExclusiveSwitchboardNote(String exclusiveSwitchboardNote) {
		this.exclusiveSwitchboardNote = exclusiveSwitchboardNote;
	}
	@Override
	public String toString() {
		return "DevExclusiveSwitchboardInfo [exclusiveSwitchboardIp="
				+ exclusiveSwitchboardIp + ", exclusiveSwitchboardPort="
				+ exclusiveSwitchboardPort + ", exclusiveSwitchboardOrder="
				+ exclusiveSwitchboardOrder + ", exclusiveSwitchboardNote="
				+ exclusiveSwitchboardNote + "]";
	}
	
}
