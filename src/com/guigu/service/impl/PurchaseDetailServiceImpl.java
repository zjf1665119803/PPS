package com.guigu.service.impl;

import java.util.List;

import com.guigu.dao.PurchaseDetailDao;
import com.guigu.dao.SalesManDao;
import com.guigu.dao.impl.PurchaseDetailDaoImpl;
import com.guigu.dao.impl.SalesManDaoImpl;
import com.guigu.pojo.PurchaseDetail;
import com.guigu.pojo.SalesMan;
import com.guigu.service.PurchaseDetailService;
import com.guigu.util.JdbcUtil;

public class PurchaseDetailServiceImpl implements PurchaseDetailService {
	private PurchaseDetailDao  purchaseDetailDao = new PurchaseDetailDaoImpl();
	@Override
	public Object[][] getPurchaseDetail(Object purchaseID) throws Exception {
		String sql = "SELECT * FROM purchaseDetail WHERE purchaseID = ?";
		List<PurchaseDetail> list = purchaseDetailDao.getForList(JdbcUtil.getConn(), sql,purchaseID);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[4];
				data[0] = list.get(i).getProductID();
				data[1] = list.get(i).getPurchaseQuantity();
				data[2] = list.get(i).getPurchaseUnitPrice();
				data[3] = list.get(i).getPurchaseAmount();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}
	}
	


