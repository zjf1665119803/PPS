package com.guigu.service.impl;

import java.util.List;

import com.guigu.dao.SalesManDao;
import com.guigu.dao.impl.SalesManDaoImpl;
import com.guigu.pojo.SalesMan;
import com.guigu.service.SalesManService;
import com.guigu.util.JdbcUtil;

public class SalesManServiceImpl implements SalesManService{
	private SalesManDao  salesManDao = new SalesManDaoImpl();
	@Override
	public Object[][] getAllSalesMan() throws Exception {
		String sql = "select * from salesman";
		List<SalesMan> list = salesManDao.getForList(JdbcUtil.getConn(), sql);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[7];
				data[0] = list.get(i).getSalesManID();
				data[1] = list.get(i).getChineseName();
				data[2] = list.get(i).getEnglishName();
				data[3] = list.get(i).getTelephone();
				data[4] = list.get(i).getMobilePhone();
				data[5] = list.get(i).getContactAddress();
				data[6] = list.get(i).getEmail();
 				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}

	
	@Override
	public boolean addSalesMan(SalesMan salesMan) throws Exception {
		String sql = "INSERT INTO salesman VALUES(?,?,?,?,?,?,?)";
		return salesManDao.update(JdbcUtil.getConn(), sql, salesMan.getSalesManID(),salesMan.getChineseName(),salesMan.getEnglishName(),
				salesMan.getTelephone(),salesMan.getMobilePhone(),salesMan.getContactAddress(),salesMan.getEmail()) > 0;
	}


	@Override
	public SalesMan getSalesMan(String salesManID) throws Exception {
		//System.out.println("11111");
		String sql = "SELECT * FROM salesMan WHERE salesManID = ?";
	    return salesManDao.get(JdbcUtil.getConn(), sql, salesManID);
	}


	@Override
	public boolean saveSalesMan(SalesMan salesMan) throws Exception {
		String sql = "UPDATE salesMan SET chineseName = ?,EnglishName = ?,telephone = ?,MobilePhone = ?,ContactAddress = ?,email = ? WHERE salesmanid = ?";
		return salesManDao.update(JdbcUtil.getConn(), sql, salesMan.getChineseName(),salesMan.getEnglishName(),
				salesMan.getTelephone(),salesMan.getMobilePhone(),salesMan.getContactAddress(),salesMan.getEmail(),salesMan.getSalesManID()) > 0;
	}


	@Override
	public boolean deleteSalesMan(SalesMan salesMan) throws Exception {
		String sql = "DELETE FROM salesMan WHERE salesManID = ?";
	    return salesManDao.update(JdbcUtil.getConn(), sql, salesMan.getSalesManID()) > 0;
	}
	
	
	}





