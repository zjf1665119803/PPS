package com.guigu.pojo;

import java.sql.Timestamp;

/**
 * 供应商实体类
 * @author ZJF
 *
 */

public class Supplier {
	
	private String SupplierID;
	private String SupplierSimpleName;
	private String SupplierName;
	private String owner;
	private String title;
	private String telephone;
	private String mobilePhone;
	private String fax;
	private String companyAddress;
	private String factoryAddress;
	private Timestamp lastPurchaseDate;
	public String getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}
	public String getSupplierSimpleName() {
		return SupplierSimpleName;
	}
	public void setSupplierSimpleName(String supplierSimpleName) {
		SupplierSimpleName = supplierSimpleName;
	}
	public String getSupplierName() {
		return SupplierName;
	}
	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getFactoryAddress() {
		return factoryAddress;
	}
	public void setFactoryAddress(String factoryAddress) {
		this.factoryAddress = factoryAddress;
	}
	public Timestamp getLastPurchaseDate() {
		return lastPurchaseDate;
	}
	public void setLastPurchaseDate(Timestamp lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	@Override
	public String toString() {
		return "Supplier [SupplierID=" + SupplierID + ", SupplierSimpleName=" + SupplierSimpleName + ", SupplierName="
				+ SupplierName + ", owner=" + owner + ", title=" + title + ", telephone=" + telephone + ", mobilePhone="
				+ mobilePhone + ", fax=" + fax + ", companyAddress=" + companyAddress + ", factoryAddress="
				+ factoryAddress + ", lastPurchaseDate=" + lastPurchaseDate + "]";
	}
	
	
	

}
