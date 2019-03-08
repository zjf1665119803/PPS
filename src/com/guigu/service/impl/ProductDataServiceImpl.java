package com.guigu.service.impl;

import java.util.List;

import com.guigu.dao.ProductDataDao;
import com.guigu.dao.impl.ProductDataDaoImpl;
import com.guigu.pojo.Product;
import com.guigu.pojo.SalesMan;
import com.guigu.service.ProductDataService;
import com.guigu.util.JdbcUtil;

public class ProductDataServiceImpl implements ProductDataService{
	private ProductDataDao  productDataDao = new ProductDataDaoImpl();
	@Override
	public Object[][] getAllProuctData() throws Exception {
		String sql = "select * from product";
		List<Product> list = productDataDao.getForList(JdbcUtil.getConn(), sql);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[8];
				data[0] = list.get(i).getProductID();
				data[1] = list.get(i).getProductName();
				data[2] = list.get(i).getSafeStock();
				data[3] = list.get(i).getLastPurchaseDate();
				data[4] = list.get(i).getLastDeliveryDate();
				data[5] = list.get(i).getQuantity();
				data[6] = list.get(i).getSuggestBuyPrice();
				data[7] = list.get(i).getSuggestSalePrice();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}
	@Override
	public boolean addProuctData(Product product) throws Exception {
		String sql = " INSERT INTO product(productid,productName,safestock,suggestBuyPrice,suggestsalePrice) VALUES(?,?,?,?,?)";
		return productDataDao.update(JdbcUtil.getConn(), sql, product.getProductID(),product.getProductName(),product.getSafeStock(),
				product.getSuggestBuyPrice(),product.getSuggestSalePrice()) > 0;
	}
	@Override
	public boolean saveProuctData(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql = "UPDATE product SET productName = ?,safestock = ?,suggestBuyPrice = ?,suggestSalePrice = ? WHERE productid = ?";
		return productDataDao.update(JdbcUtil.getConn(), sql, product.getProductName(),product.getSafeStock(),
				product.getSuggestBuyPrice(),product.getSuggestSalePrice(),product.getProductID()) > 0;
	}
	
	@Override
	public boolean deleteProuctData(Product product) throws Exception {
		String sql = "DELETE FROM product WHERE ProductID = ?";
		return productDataDao.update(JdbcUtil.getConn(), sql, product.getProductID()) > 0;
		
	}
	@Override
	public Product getProduct(String  productID) throws Exception {
		String sql = "select * from product where productID = ?";
		return productDataDao.get(JdbcUtil.getConn(), sql, productID);
		
	}
	@Override
	public Object[][] getProuctDataBySafeStockAndQuantity(String productID,String productName, String select) throws Exception {
		// TODO Auto-generated method stub
       	/*System.out.println("-----------");
		System.out.println(select);
		System.out.println(productID);
		System.out.println(productName);*/
		String sql = null;
		if(select.equals(">")){
			sql = "select * from product WHERE ProductID = ? AND ProductName = ? AND SafeStock > Quantity";
		}
		if(select.equals("<")){
			sql = "select * from product WHERE ProductID = ? AND ProductName = ? AND SafeStock < Quantity";
		}
		if(select.equals("=")){
		    sql = "select * from product WHERE ProductID = ? AND ProductName = ? AND SafeStock = Quantity";
		}
		List<Product> list = productDataDao.getForList(JdbcUtil.getConn(), sql,productID,productName);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[6];
				data[0] = list.get(i).getProductID();
				data[1] = list.get(i).getProductName();
				data[2] = list.get(i).getSafeStock();
				data[3] = list.get(i).getLastPurchaseDate();
				data[4] = list.get(i).getLastDeliveryDate();
				data[5] = list.get(i).getQuantity();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
		
	}
	
	
}
