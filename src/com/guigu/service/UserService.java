package com.guigu.service;

import com.guigu.pojo.User;

public interface UserService {
	//登录检验
	User logIn(String userName,String passWordCode,StringBuffer sbf) throws Exception ;

	Object[][] getAllUsers()throws Exception;
    
	//添加用户
	boolean addUser(User user)throws Exception;

	boolean saveUser(String string1, String string2, String string3, String string4)throws Exception;

	boolean deleteUser(String string)throws Exception;

	boolean noUser(String string)throws Exception;
    //用户密码修改
	boolean savePasswordUser(String userName, String password)throws Exception;

	

}
