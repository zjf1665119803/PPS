package com.guigu.service.impl;

import java.util.List;

import com.guigu.dao.PurchaseDetailDao;
import com.guigu.dao.PurchaseMasterDao;
import com.guigu.dao.SupplierContactManDao;
import com.guigu.dao.impl.PurchaseDetailDaoImpl;
import com.guigu.dao.impl.PurchaseMasterDaoImpl;
import com.guigu.dao.impl.SupplierContactManDaoImpl;
import com.guigu.pojo.PurchaseDetail;
import com.guigu.pojo.PurchaseMaster;
import com.guigu.pojo.SupplierContactMan;
import com.guigu.service.SupplierContactManService;
import com.guigu.util.JdbcUtil;

public class SupplierContactManServiceImpl implements SupplierContactManService{
	SupplierContactManDao supplierContactManDao = new SupplierContactManDaoImpl();
	PurchaseMasterDao purchaseMasterDao = new PurchaseMasterDaoImpl();
	PurchaseDetailDao purchaseDetailDao = new PurchaseDetailDaoImpl();
	@Override
	public Object[][] getsupplierContactMan(String SupplierID) throws Exception{
		String sql = "select * from supplierContactMan where SupplierID = ? ";
		List<SupplierContactMan> list = supplierContactManDao.getForList(JdbcUtil.getConn(), sql,SupplierID);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[6];
				data[0] = list.get(i).getContactID();
				data[1] = list.get(i).getChineseName();
				data[2] = list.get(i).getEnglishName();
				data[3] = list.get(i).getTtitle();
				data[4] = list.get(i).getTelephone();
				data[5] = list.get(i).getMobilePhone();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}
	@Override
	public Object[][] getDeliveryData(String supplierID) throws Exception {
		String sql = "select * from PurchaseMaster WHERE supplierID = ?";
		List<PurchaseMaster> list = purchaseMasterDao.getForList(JdbcUtil.getConn(), sql,supplierID);
		/*String sql1 = "select * from PurchaseDetail WHERE purchaseID = ?";
		List<PurchaseDetail> list1 = purchaseDetailDao.getForList(JdbcUtil.getConn(), sql1,list.get(i).getPurchaseID());
		if(list1 != null && list1.size() > 0) {*/
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[5];
				data[0] = list.get(i).getPurchaseID();
				data[1] = list.get(i).getPurchaseProperty();
				data[2] = list.get(i).getPurchaseDate();
				data[3] = list.get(i).getInvoiceID();
				data[4] = list.get(i).getPurchaseID();
 				tableData[i] = data;
				}
			
			return tableData;
		}
		return null;
	}

}
