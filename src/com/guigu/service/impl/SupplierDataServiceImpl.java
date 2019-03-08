package com.guigu.service.impl;

import java.util.List;

import com.guigu.dao.SupplierDataDao;
import com.guigu.dao.impl.SupplierDataDaoImpl;
import com.guigu.pojo.Customer;
import com.guigu.pojo.Supplier;
import com.guigu.service.SupplierDataService;
import com.guigu.util.JdbcUtil;

public class SupplierDataServiceImpl implements SupplierDataService{
    SupplierDataDao supplierDataDao = new SupplierDataDaoImpl();
	@Override
	public Object[][] getAllSupplier() throws Exception {
		String sql = "select * from supplier";
		List<Supplier> list = supplierDataDao.getForList(JdbcUtil.getConn(), sql);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[11];
				data[0] = list.get(i).getSupplierID();
				data[1] = list.get(i).getSupplierSimpleName();
				data[2] = list.get(i).getSupplierName();
				data[3] = list.get(i).getOwner();
				data[4] = list.get(i).getTitle();
				data[5] = list.get(i).getTelephone();
				data[6] = list.get(i).getMobilePhone();
				data[7] = list.get(i).getFax();
				data[8] = list.get(i).getCompanyAddress();
				data[9] = list.get(i).getFactoryAddress();
				data[10] = list.get(i).getLastPurchaseDate();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}
	@Override
	public Supplier getSupplier(String supplierID) throws Exception {
		String sql = "SELECT * FROM supplier WHERE supplierID = ?";
	    return supplierDataDao.get(JdbcUtil.getConn(), sql, supplierID);
	}
	@Override
	public boolean addsupplier(Supplier supplier) throws Exception {
		String sql = " INSERT INTO supplier(supplierId,supplierSimpleName,supplierName,"
				+ "OWNER,title,telephone,mobilephone,fax,CompanyAddress,FactoryAddress)" + 
				" VALUES(?,?,?,?,?,?,?,?,?,?)";
		return supplierDataDao.update(JdbcUtil.getConn(), sql, supplier.getSupplierID(),supplier.getSupplierSimpleName(),supplier.getSupplierName(),
				supplier.getOwner(),supplier.getTitle(),supplier.getTelephone(),supplier.getMobilePhone(),supplier.getFax(),supplier.getCompanyAddress(),
				supplier.getFactoryAddress()) > 0;
	}
	@Override
	public boolean savesupplier(Supplier supplier) throws Exception {
		String sql = "UPDATE supplier SET supplierSimpleName = ?,supplierName = ?," + 
				"OWNER = ?,title = ?,telephone = ?,mobilephone = ?,fax = ?,CompanyAddress =?,FactoryAddress = ? WHERE supplierId = ?";
		return supplierDataDao.update(JdbcUtil.getConn(), sql,supplier.getSupplierSimpleName(),supplier.getSupplierName(),
				supplier.getOwner(),supplier.getTitle(),supplier.getTelephone(),supplier.getMobilePhone(),supplier.getFax(),supplier.getCompanyAddress(),
				supplier.getFactoryAddress(),supplier.getSupplierID() ) > 0;
	}
	@Override
	public boolean deletesupplier(Supplier supplier) throws Exception {
		String sql = "DELETE FROM supplier WHERE SupplierID = ?";
		return supplierDataDao.update(JdbcUtil.getConn(), sql, supplier.getSupplierID()) > 0;
	}

}
