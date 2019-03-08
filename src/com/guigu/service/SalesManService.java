package com.guigu.service;

import com.guigu.pojo.SalesMan;

/**
 * 	销售人员业务逻辑表
 * @author ZJF
 *
 */

public interface SalesManService {
	
	//显示所有员工
	Object [][] getAllSalesMan() throws Exception;
	
	//新增
	boolean addSalesMan(SalesMan salesMan) throws Exception;

	//取消
	
	//保存
	boolean saveSalesMan(SalesMan salesMan)throws Exception;
	
	//删除
	boolean deleteSalesMan(SalesMan salesMan)throws Exception;
	//退出

   SalesMan getSalesMan(String string)throws Exception;


	

}
