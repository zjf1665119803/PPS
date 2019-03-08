package com.guigu.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.guigu.dao.CustomerDataDao;
import com.guigu.dao.impl.CustomerDataDaoImpl;
import com.guigu.pojo.Customer;
import com.guigu.pojo.Product;
import com.guigu.service.CustomerDataService;
import com.guigu.util.JdbcUtil;

public class CustomerDataServiceImpl implements CustomerDataService {
	private CustomerDataDao customerDataDao = new CustomerDataDaoImpl();
	@Override
	public Object[][] getAllCustomer() throws Exception {
		String sql = "select * from customer";
		List<Customer> list = customerDataDao.getForList(JdbcUtil.getConn(), sql);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[13];
				data[0] = list.get(i).getCustomerID();
				data[1] = list.get(i).getCustomerSimpleName();
				data[2] = list.get(i).getCustomerName();
				data[3] = list.get(i).getOwner();
				data[4] = list.get(i).getTitle();
				data[5] = list.get(i).getTelephone();
				data[6] = list.get(i).getMobilePhone();
				data[7] = list.get(i).getFax();
				data[8] = list.get(i).getSalesManID();
				data[9] = list.get(i).getCustomerAddress();
				data[10] = list.get(i).getDeliveryAddress();
				data[11] = list.get(i).getInvoiceAddress();
				data[12] = list.get(i).getLastDeliveryDate();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}
	@Override
	public Customer getCustomer(String customerID) throws Exception {
		String sql = "SELECT * FROM customer WHERE customerID = ?";
	    return customerDataDao.get(JdbcUtil.getConn(), sql, customerID);
	
	}
	@Override
	public Object[] getSalesManID() throws Exception {
		String sql = "SELECT DISTINCT salesManID FROM salesMan ";
		List<Customer> list = customerDataDao.getForList(JdbcUtil.getConn(), sql);
		Object[] str = list.toArray(new Object[0]);
		///System.out.println("-------");
		for(int i = 0;i < str.length;i++) {
			str[i] = list.get(i).getSalesManID();
			//System.out.println(str[i]);
		}
		
		return str;
	}
	@Override
	public boolean addCustomer(Customer customer) throws Exception {
		String sql = "  INSERT INTO customer(customerId,customerSimpleName,customerName,"
				+ "OWNER,title,telephone,mobilephone,fax,salesManid,customerAddress,deliveryAddress,InvoiceAddress)" + 
				" VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		return customerDataDao.update(JdbcUtil.getConn(), sql, customer.getCustomerID(),customer.getCustomerSimpleName(),customer.getCustomerName(),
				customer.getOwner(),customer.getTitle(),customer.getTelephone(),customer.getMobilePhone(),customer.getFax(),customer.getSalesManID(),
				customer.getCustomerAddress(),customer.getDeliveryAddress(),customer.getInvoiceAddress()) > 0;
	}
	@Override
	public boolean saveCustomer(Customer customer) throws Exception {
		String sql = "UPDATE customer SET customerSimpleName = ?,customerName = ?," + 
				"OWNER = ?,title = ?,telephone = ?,mobilephone = ?,fax = ?,salesManid =?,customerAddress = ?,deliveryAddress = ?,"
				+ "InvoiceAddress = ? WHERE customerId = ?";
		return customerDataDao.update(JdbcUtil.getConn(), sql, customer.getCustomerSimpleName(),customer.getCustomerName(),
				customer.getOwner(),customer.getTitle(),customer.getTelephone(),customer.getMobilePhone(),customer.getFax(),customer.getSalesManID(),
				customer.getCustomerAddress(),customer.getDeliveryAddress(),customer.getInvoiceAddress(),customer.getCustomerID()) > 0;
	
	}
	@Override
	public boolean deleteCustomer(Customer customer) throws Exception {
		String sql = "DELETE FROM customer WHERE CustomerID = ?";
		return customerDataDao.update(JdbcUtil.getConn(), sql, customer.getCustomerID()) > 0;
	}
	
}
