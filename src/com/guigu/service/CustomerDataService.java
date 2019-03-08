package com.guigu.service;

import com.guigu.pojo.Customer;

/**
 * 客户资料的业务逻辑层接口
 * @author ZJF
 *
 */

public interface CustomerDataService {

	Object[][] getAllCustomer()throws Exception;
    
	Customer getCustomer(String string)throws Exception;
	//获得所有销售员id
	Object[] getSalesManID() throws Exception;

	boolean addCustomer(Customer customer)throws Exception;

	boolean saveCustomer(Customer customer)throws Exception;

	boolean deleteCustomer(Customer customer)throws Exception;
}
