package com.guigu.service.impl;

import java.util.List;

import com.guigu.dao.CustomerContactManDao;
import com.guigu.dao.DeliveryMasterDao;
import com.guigu.dao.impl.CustomerContactManDaoImpl;
import com.guigu.dao.impl.DeliveryMasterDaoImpl;
import com.guigu.pojo.CustomerContactMan;
import com.guigu.pojo.DeliveryMaster;
import com.guigu.service.CustomerContactManService;
import com.guigu.util.JdbcUtil;
public class CustomerContactManServiceImpl implements CustomerContactManService{
	private CustomerContactManDao customerContactManDao = new CustomerContactManDaoImpl();
	private DeliveryMasterDao deliveryMasterDao = new DeliveryMasterDaoImpl();

	@Override
	public Object[][] getcustomerContactMan(String customerID) throws Exception {
			String sql = "select * from customerContactMan WHERE customerID = ?";
			List<CustomerContactMan> list = customerContactManDao.getForList(JdbcUtil.getConn(), sql,customerID);
			if(list != null && list.size() > 0) {
				Object[][] tableData = new Object[list.size()][];
				for(int i = 0;i<list.size();i++) {
					Object[] data = new Object[5];
					data[0] = list.get(i).getChineseName();
					data[1] = list.get(i).getEnglishName();
					data[2] = list.get(i).getTitle();
					data[3] = list.get(i).getTelephone();
					data[4] = list.get(i).getMobilePhone();
	 				tableData[i] = data;
				} 
				return tableData;
			}
			return null;
		}

	@Override
	public Object[][] getDeliveryData(String customerID) throws Exception {
		String sql = "select * from DeliveryMaster WHERE customerID = ?";
		List<DeliveryMaster> list = deliveryMasterDao.getForList(JdbcUtil.getConn(), sql,customerID);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[6];
				data[0] = list.get(i).getDeliveryID();
				data[1] = list.get(i).getDeliveryProperty();
				data[2] = list.get(i).getDeliveryDate();
				data[3] = list.get(i).getSalesManID();
				data[4] = list.get(i).getDeliveryAddress();
				data[5] = list.get(i).getInvoiceID();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}	

}
