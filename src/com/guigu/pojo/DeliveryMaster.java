package com.guigu.pojo;

import java.sql.Timestamp;

/**
 * 销售主实体类
 * @author ZJF
 *
 */

public class DeliveryMaster {
	
	private String deliveryID;
	private int deliveryProperty;
	private Timestamp deliveryDate;
	private String customerID;
	private String SalesManID;
	private String DeliveryAddress;
	private String InvoiceID;
	@Override
	public String toString() {
		return "DeliveryMaster [deliveryID=" + deliveryID + ", deliveryProperty=" + deliveryProperty + ", deliveryDate="
				+ deliveryDate + ", customerID=" + customerID + ", SalesManID=" + SalesManID + ", DeliveryAddress="
				+ DeliveryAddress + ", InvoiceID=" + InvoiceID + "]";
	}
	public String getDeliveryID() {
		return deliveryID;
	}
	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}
	public int getDeliveryProperty() {
		return deliveryProperty;
	}
	public void setDeliveryProperty(int deliveryProperty) {
		this.deliveryProperty = deliveryProperty;
	}
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getCustomerID() {
		return customerID;
	}
	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	public String getSalesManID() {
		return SalesManID;
	}
	public void setSalesManID(String salesManID) {
		SalesManID = salesManID;
	}
	public String getDeliveryAddress() {
		return DeliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		DeliveryAddress = deliveryAddress;
	}
	public String getInvoiceID() {
		return InvoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		InvoiceID = invoiceID;
	}
	
	
}
