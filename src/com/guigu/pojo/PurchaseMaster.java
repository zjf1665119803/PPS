package com.guigu.pojo;

import java.sql.Timestamp;

/**
 * 采购主实体类
 * @author ZJF
 *
 */

public class PurchaseMaster {
	
	private String purchaseID;
	private Timestamp purchaseDate;
	private String SupplierID;
	private int purchaseProperty;
	private String InvoiceID;
	
	public String getInvoiceID() {
		return InvoiceID;
	}
	public void setInvoiceID(String invoiceID) {
		InvoiceID = invoiceID;
	}
	public String getPurchaseID() {
		return purchaseID;
	}
	public void setPurchaseID(String purchaseID) {
		this.purchaseID = purchaseID;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getSupplierID() {
		return SupplierID;
	}
	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}
	public int getPurchaseProperty() {
		return purchaseProperty;
	}
	public void setPurchaseProperty(int purchaseProperty) {
		this.purchaseProperty = purchaseProperty;
	}
	@Override
	public String toString() {
		return "PurchaseMaster [purchaseID=" + purchaseID + ", purchaseDate=" + purchaseDate + ", SupplierID="
				+ SupplierID + ", purchaseProperty=" + purchaseProperty + ", InvoiceID=" + InvoiceID + "]";
	}
	
	
	

}
