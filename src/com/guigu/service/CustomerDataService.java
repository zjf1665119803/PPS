package com.guigu.service;

import com.guigu.pojo.Customer;

/**
 * �ͻ����ϵ�ҵ���߼���ӿ�
 * @author ZJF
 *
 */

public interface CustomerDataService {

	Object[][] getAllCustomer()throws Exception;
    
	Customer getCustomer(String string)throws Exception;
	//�����������Աid
	Object[] getSalesManID() throws Exception;

	boolean addCustomer(Customer customer)throws Exception;

	boolean saveCustomer(Customer customer)throws Exception;

	boolean deleteCustomer(Customer customer)throws Exception;
}
