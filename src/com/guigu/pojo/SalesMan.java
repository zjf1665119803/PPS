package com.guigu.pojo;
/**
 * 销售人员实体类
 * @author ZJF
 *
 */
public class SalesMan {
    
	private String salesManID;
	private String chineseName;
	private String englishName;
	private String telephone;
	private String mobilePhone;
	private String contactAddress;
	private String email;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSalesManID() {
		return salesManID;
	}
	public void setSalesManID(String salesManID) {
		this.salesManID = salesManID;
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
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	@Override
	public String toString() {
		return "SalesMan [salesManID=" + salesManID + ", chineseName=" + chineseName + ", englishName=" + englishName
				+ ", telephone=" + telephone + ", mobilePhone=" + mobilePhone + ", contactAddress=" + contactAddress
				+ ", email=" + email + "]";
	}
	
	
	
}
