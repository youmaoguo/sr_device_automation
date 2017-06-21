package com.sunrun.entity;

import java.io.Serializable;

public class Test implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String ip;
	private Integer status;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", ip=" + ip + ", status=" + status + "]";
	}
	

}
