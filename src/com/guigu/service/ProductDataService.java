package com.guigu.service;

import com.guigu.pojo.Product;

/**
 * ��Ʒ���ϵ�ҵ���߼���ӿ�
 * @author ZJF
 *
 */

public interface ProductDataService {
	
	//��ʾ������Ʒ
		Object [][] getAllProuctData() throws Exception;
		
		//����
		boolean addProuctData(Product product) throws Exception;
		
		//ȡ��
		
		//����
		boolean saveProuctData(Product product)throws Exception;
		
		//ɾ��
		boolean deleteProuctData(Product product)throws Exception;
		//�˳�

	    Product getProduct(String string)throws Exception;
        //��ѯ���
		Object[][] getProuctDataBySafeStockAndQuantity(String productID,String productName, String string)throws Exception;
}
