package com.guigu.service;

import com.guigu.pojo.SalesMan;

/**
 * 	������Աҵ���߼���
 * @author ZJF
 *
 */

public interface SalesManService {
	
	//��ʾ����Ա��
	Object [][] getAllSalesMan() throws Exception;
	
	//����
	boolean addSalesMan(SalesMan salesMan) throws Exception;

	//ȡ��
	
	//����
	boolean saveSalesMan(SalesMan salesMan)throws Exception;
	
	//ɾ��
	boolean deleteSalesMan(SalesMan salesMan)throws Exception;
	//�˳�

   SalesMan getSalesMan(String string)throws Exception;


	

}
