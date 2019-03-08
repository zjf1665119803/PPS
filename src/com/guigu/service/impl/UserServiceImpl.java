package com.guigu.service.impl;

import java.util.List;

import com.guigu.dao.UserDao;
import com.guigu.dao.impl.UserDaoImpl;
import com.guigu.pojo.Product;
import com.guigu.pojo.User;
import com.guigu.service.UserService;
import com.guigu.util.JdbcUtil;

public class UserServiceImpl implements UserService{
	private UserDao userDao = new UserDaoImpl();

	@Override
	public User logIn(String userName, String passWordCode,StringBuffer sbf) throws Exception {
		String sql = "SELECT * FROM USER  WHERE userName = ?  AND passWordCode = ?";
		User user =  userDao.get(JdbcUtil.getConn(), sql, userName,passWordCode);//进行查询
		if(user == null) {
			sbf.append("用户名或者密码不正确!");
			
			return null;
		}else {
			return user;
		}
		
	}

	@Override
	public Object[][] getAllUsers() throws Exception {
		
		String sql = "select * from user";
		List<User> list = userDao.getForList(JdbcUtil.getConn(), sql);
		if(list != null && list.size() > 0) {
			Object[][] tableData = new Object[list.size()][];
			for(int i = 0;i<list.size();i++) {
				Object[] data = new Object[4];
				data[0] = list.get(i).getUserID();
				data[1] = list.get(i).getUserName();
				data[2] = list.get(i).getPasswordCode();
				data[3] = list.get(i).getIsUse();
				tableData[i] = data;
			} 
			return tableData;
		}
		return null;
	}

	@Override
	public boolean addUser(User user) throws Exception {
		String sql = "INSERT INTO user(UserID,userName,passwordcode) VALUES(?,?,?)";
		return userDao.update(JdbcUtil.getConn(), sql, user.getUserID(),user.getUserName(),user.getPasswordCode()) > 0;
	     
        //return null;
	}

	
	@Override
	public boolean saveUser(String UserID, String userName, String passwordcode, String isUse) throws Exception {
		
		String sql = "UPDATE User SET userName = ?,passwordCode = ?,isUse = ? WHERE UserID = ?";
		return userDao.update(JdbcUtil.getConn(),sql,userName,passwordcode, isUse, UserID) > 0;
	
	}

	@Override
	public boolean deleteUser(String UserID) throws Exception {
		String sql = "DELETE FROM User WHERE UserID = ?";
	    return userDao.update(JdbcUtil.getConn(), sql, UserID ) > 0;
	}

	@Override
	public boolean noUser(String UserID) throws Exception {
		String sql = "UPDATE User SET isUse = ? WHERE UserID = ?";
		return userDao.update(JdbcUtil.getConn(),sql,-1, UserID) > 0;
	}

	@Override
	public boolean savePasswordUser(String userName, String passwordcode) throws Exception {
		String sql = "UPDATE User SET passwordCode = ? WHERE userName = ?";
		return userDao.update(JdbcUtil.getConn(),sql,passwordcode,userName) > 0;
	}
}
