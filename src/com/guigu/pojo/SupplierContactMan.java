package com.guigu.pojo;
/**
 * 供应商实体类
 * @author ZJF
 *
 */

public class SupplierContactMan {
	
	private int contactID;
	private String ChineseName;
	private String EnglishName;
	private String ttitle;
	private String telephone;
	private String mobilePhone;
	private String SupplierID;
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getChineseName() {
		return ChineseName;
	}
	public void setChineseName(String chineseName) {
		ChineseName = chineseName;
	}
	public String getEnglishName() {
		return EnglishName;
	}
	public void setEnglishName(String englishName) {
		EnglishName = englishName;
	}
	public String getTtitle() {
		return ttitle;
	}
	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}
	@Override
	public String toString() {
		return "SupplierContactMan [contactID=" + contactID + ", ChineseName=" + ChineseName + ", EnglishName="
				+ EnglishName + ", ttitle=" + ttitle + ", telephone=" + telephone + ", mobilePhone=" + mobilePhone
				+ ", SupplierID=" + SupplierID + "]";
	}
	
	

}
