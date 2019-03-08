package com.guigu.pojo;

import java.sql.Timestamp;

/**
 * 客户信息实体类
 * @author ZJF
 *
 */
public class Customer {
	
  private String customerID;
  private String customerSimpleName;
  private String customerName;
  private String owner;
  private String title;
  private String telephone;
  private String mobilePhone;
  private String fax;
  private String salesManID;
  private String customerAddress;
  private String deliveryAddress;
  private String invoiceAddress;
  private Timestamp lastDeliveryDate;
@Override
public String toString() {
	return "Customer [customerID=" + customerID + ", customerSimpleName=" + customerSimpleName + ", customerName="
			+ customerName + ", owner=" + owner + ", title=" + title + ", telephone=" + telephone + ", mobilePhone="
			+ mobilePhone + ", fax=" + fax + ", salesManID=" + salesManID + ", customerAddress=" + customerAddress
			+ ", deliveryAddress=" + deliveryAddress + ", invoiceAddress=" + invoiceAddress + ", lastDeliveryDate="
			+ lastDeliveryDate + "]";
}
public String getCustomerID() {
	return customerID;
}
public void setCustomerID(String customerID) {
	this.customerID = customerID;
}
public String getCustomerSimpleName() {
	return customerSimpleName;
}
public void setCustomerSimpleName(String customerSimpleName) {
	this.customerSimpleName = customerSimpleName;
}
public String getCustomerName() {
	return customerName;
}
public void setCustomerName(String customerName) {
	this.customerName = customerName;
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
public String getSalesManID() {
	return salesManID;
}
public void setSalesManID(String salesManID) {
	this.salesManID = salesManID;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public String getDeliveryAddress() {
	return deliveryAddress;
}
public void setDeliveryAddress(String deliveryAddress) {
	this.deliveryAddress = deliveryAddress;
}
public String getInvoiceAddress() {
	return invoiceAddress;
}
public void setInvoiceAddress(String invoiceAddress) {
	this.invoiceAddress = invoiceAddress;
}
public Timestamp getLastDeliveryDate() {
	return lastDeliveryDate;
}
public void setLastDeliveryDate(Timestamp lastDeliveryDate) {
	this.lastDeliveryDate = lastDeliveryDate;
}
  
}
