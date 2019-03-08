package com.guigu.pojo;
/**
 * 客户联系人实体类
 * @author ZJF
 *
 */
public class CustomerContactMan {

	private int contactID;
	private String chineseName;
	private String englishName;
	private String ttitle;
	private String telephone;
	private String mobilePhone;
	private String customerID;
	public int getContactID() {
		return contactID;
	}
	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public String getTitle() {
		return ttitle;
	}
	public void setTitle(String title) {
		this.ttitle = title;
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
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	@Override
	public String toString() {
		return "CustomerContactMan [contactID=" + contactID + ", chineseName=" + chineseName + ", englishName="
				+ englishName + ", title=" + ttitle + ", telephone=" + telephone + ", mobilePhone=" + mobilePhone
				+ ", customerID=" + customerID + "]";
	}
	
	
	
}
