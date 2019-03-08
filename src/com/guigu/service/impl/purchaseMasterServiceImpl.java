package com.guigu.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.guigu.dao.PurchaseMasterDao;
import com.guigu.dao.impl.PurchaseMasterDaoImpl;
import com.guigu.pojo.PurchaseMaster;
import com.guigu.service.PurchaseMasterService;
import com.guigu.util.JdbcUtil;

public class purchaseMasterServiceImpl implements PurchaseMasterService {
	PurchaseMasterDao purchaseMasterDao = new PurchaseMasterDaoImpl();
	@Override
	public Object[] getSupplierID() throws Exception {
		String sql = "SELECT DISTINCT SupplierID FROM PurchaseMaster ";
		List<PurchaseMaster> list = purchaseMasterDao.getForList(JdbcUtil.getConn(), sql);
		Object[] str = list.toArray(new Object[0]);
		///System.out.println("-------");
		for(int i = 0;i < str.length;i++) {
			str[i] = list.get(i).getSupplierID();
			//System.out.println(str[i]);
		}
		
		return str;
	}

	@Override
	public Object[] getPurchaseID(Object supplierID) throws Exception {
		String sql = "SELECT * FROM PurchaseMaster WHERE SupplierID = ?";
		List<PurchaseMaster> list = purchaseMasterDao.getForList(JdbcUtil.getConn(), sql,supplierID);
		Object[] str1 = list.toArray(new Object[0]);
	    System.out.println("-------");
		for(int i = 0;i < str1.length;i++) {
			str1[i] = list.get(i).getPurchaseID();
			System.out.println(str1[i]);
		}
		
		return str1;
	}
	

}
