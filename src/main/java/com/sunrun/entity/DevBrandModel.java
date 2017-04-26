package com.sunrun.entity;

/**
 * 设备品牌型号对应表
 * @author ymg
 *
 */
public class DevBrandModel extends BaseEntity{

	private String brandName;	//'品牌名称',
	private String modelName;	//'型号',
	private String iosVersion;	//'IOS版本信息',
	private String iosVersion2;	//'备用字段',
	
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getIosVersion() {
		return iosVersion;
	}
	public void setIosVersion(String iosVersion) {
		this.iosVersion = iosVersion;
	}
	public String getIosVersion2() {
		return iosVersion2;
	}
	public void setIosVersion2(String iosVersion2) {
		this.iosVersion2 = iosVersion2;
	}
	@Override
	public String toString() {
		return "DevBrandModel [brandName=" + brandName + ", modelName="
				+ modelName + ", iosVersion=" + iosVersion + ", iosVersion2="
				+ iosVersion2 + "]";
	}
	
	
	
}