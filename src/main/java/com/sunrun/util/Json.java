package com.sunrun.util;

/**
 * 
 * @author 响应的封装json工具
 *
 */
public class Json {
	
	private Integer ret_code;	//状态码：
	private String ret_info;	//提示信息
	private Object data;		//返回的响应数据
	private Object field_info;	//返回的字段说明解析
	private Object collect;		//返回的分页数：total:100,pagesize:20
	private Boolean success;
	
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public Integer getRet_code() {
		return ret_code;
	}
	public void setRet_code(Integer ret_code) {
		this.ret_code = ret_code;
	}
	public String getRet_info() {
		return ret_info;
	}
	public void setRet_info(String ret_info) {
		this.ret_info = ret_info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	public Object getField_info() {
		return field_info;
	}
	public void setField_info(Object field_info) {
		this.field_info = field_info;
	}
	public Object getCollect() {
		return collect;
	}
	public void setCollect(Object collect) {
		this.collect = collect;
	}
	
	
}
