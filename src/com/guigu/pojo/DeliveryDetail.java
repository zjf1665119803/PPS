package com.guigu.pojo;

import java.math.BigDecimal;

/**
 * 销售明细表
 * @author ZJF
 *
 */
public class DeliveryDetail {
	private String deliverID;
	private String productID;
	private BigDecimal salesQuantity;
	private BigDecimal SalesUnitPrice;
	private BigDecimal salesAmount;
	public String getDeliverID() {
		return deliverID;
	}
	public void setDeliverID(String deliverID) {
		this.deliverID = deliverID;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public BigDecimal getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(BigDecimal salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public BigDecimal getSalesUnitPrice() {
		return SalesUnitPrice;
	}
	public void setSalesUnitPrice(BigDecimal salesUnitPrice) {
		SalesUnitPrice = salesUnitPrice;
	}
	public BigDecimal getSalesAmount() {
		return salesAmount;
	}
	public void setSalesAmount(BigDecimal salesAmount) {
		this.salesAmount = salesAmount;
	}
	@Override
	public String toString() {
		return "DeliveryDetail [deliverID=" + deliverID + ", productID=" + productID + ", salesQuantity="
				+ salesQuantity + ", SalesUnitPrice=" + SalesUnitPrice + ", salesAmount=" + salesAmount + "]";
	}
	

}
