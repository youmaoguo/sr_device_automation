package com.sunrun.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基类
 * @author ymg
 *
 */
public class BaseEntity {
	
	/**ID，uuid产生*/
	protected String id;
	
	/**创建时间*/
	protected Date createTime;
	
	/**创建人员ID*/
	protected String createUser;
	
	/**修改时间*/
	protected Date updateTime;
	
	/**修改人员ID*/
	protected String updateUser;
	
	/**状态 0 代表已删除，1代表正常*/
	protected int state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreate_time() {
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

	public void setCreate_user(String createUser) {
		this.createUser = createUser;
	}

	public String getUpdate_time() {
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	} 
	
}
