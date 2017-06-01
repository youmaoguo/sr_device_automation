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
	protected Date create_time;
	
	/**创建人员ID*/
	protected String create_user;
	
	/**修改时间*/
	protected Date update_time;
	
	/**修改人员ID*/
	protected String update_user;
	
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
		if(create_time!=null){
			s = fmt.format(create_time);
		}
		return s;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getUpdate_time() {
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String s = "";
		if(update_time!=null){
			s = fmt.format(update_time);
		}
		return s;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	} 
	
}
