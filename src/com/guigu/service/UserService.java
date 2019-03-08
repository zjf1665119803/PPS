package com.guigu.service;

import com.guigu.pojo.User;

public interface UserService {
	//��¼����
	User logIn(String userName,String passWordCode,StringBuffer sbf) throws Exception ;

	Object[][] getAllUsers()throws Exception;
    
	//����û�
	boolean addUser(User user)throws Exception;

	boolean saveUser(String string1, String string2, String string3, String string4)throws Exception;

	boolean deleteUser(String string)throws Exception;

	boolean noUser(String string)throws Exception;
    //�û������޸�
	boolean savePasswordUser(String userName, String password)throws Exception;

	

}
