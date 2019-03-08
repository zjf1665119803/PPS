package com.guigu.pojo;
/**
 * 采购明细表实体类
 * @author ZJF
 *
 */
public class PurchaseDetail {
	
	private String purchaseID;
	private String productID;
	private int purchaseQuantity;
	private int purchaseUnitPrice;
	private int purchaseAmount;
	public String getPurchaseID() {
		return purchaseID;
	}
	public void setPurchaseID(String purchaseID) {
		this.purchaseID = purchaseID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getPurchaseQuantity() {
		return purchaseQuantity;
	}
	public void setPurchaseQuantity(int purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}
	public int getPurchaseUnitPrice() {
		return purchaseUnitPrice;
	}
	public void setPurchaseUnitPrice(int purchaseUnitPrice) {
		this.purchaseUnitPrice = purchaseUnitPrice;
	}
	public int getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(int purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	@Override
	public String toString() {
		return "PurchaseDetail [purchaseID=" + purchaseID + ", productID=" + productID + ", purchaseQuantity="
				+ purchaseQuantity + ", purchaseUnitPrice=" + purchaseUnitPrice + ", purchaseAmount=" + purchaseAmount
				+ "]";
	}
	
	
	

}
