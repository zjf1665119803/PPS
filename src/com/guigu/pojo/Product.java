package com.guigu.pojo;
/**
 * 产品实体类
 * @author ZJF
 *
 */

import java.sql.Timestamp;

public class Product {
	
	private String productID;
	private String productName;
	private int safeStock;
	private Timestamp lastPurchaseDate;
	private Timestamp lastDeliveryDate;
	private int quantity;
	private int suggestBuyPrice;
	private int suggestSalePrice;
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getSafeStock() {
		return safeStock;
	}
	public void setSafeStock(int safeStock) {
		this.safeStock = safeStock;
	}
	public Timestamp getLastPurchaseDate() {
		return lastPurchaseDate;
	}
	public void setLastPurchaseDate(Timestamp lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	public Timestamp getLastDeliveryDate() {
		return lastDeliveryDate;
	}
	public void setLastDeliveryDate(Timestamp lastDeliveryDate) {
		this.lastDeliveryDate = lastDeliveryDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSuggestBuyPrice() {
		return suggestBuyPrice;
	}
	public void setSuggestBuyPrice(int suggestBuyPrice) {
		this.suggestBuyPrice = suggestBuyPrice;
	}
	public int getSuggestSalePrice() {
		return suggestSalePrice;
	}
	public void setSuggestSalePrice(int suggestSalePrice) {
		this.suggestSalePrice = suggestSalePrice;
	}
	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", safeStock=" + safeStock
				+ ", lastPurchaseDate=" + lastPurchaseDate + ", lastDeliveryDate=" + lastDeliveryDate + ", quantity="
				+ quantity + ", suggestBuyPrice=" + suggestBuyPrice + ", suggestSalePrice=" + suggestSalePrice + "]";
	}

	
	
}