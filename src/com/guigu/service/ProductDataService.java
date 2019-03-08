package com.guigu.service;

import com.guigu.pojo.Product;

/**
 * 商品资料的业务逻辑层接口
 * @author ZJF
 *
 */

public interface ProductDataService {
	
	//显示所有商品
		Object [][] getAllProuctData() throws Exception;
		
		//新增
		boolean addProuctData(Product product) throws Exception;
		
		//取消
		
		//保存
		boolean saveProuctData(Product product)throws Exception;
		
		//删除
		boolean deleteProuctData(Product product)throws Exception;
		//退出

	    Product getProduct(String string)throws Exception;
        //查询库存
		Object[][] getProuctDataBySafeStockAndQuantity(String productID,String productName, String string)throws Exception;
}
