package com.guigu.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	/**
	 * ��������ķ���
	 * @param connection
	 * @param sql
	 * @param args ���ռλ��
	 * @throws SQLException
	 */
	int[] batch(Connection connection,String sql,Object[]...args) throws SQLException;
	/**
	 * ���ص���һ��ֵ
	  * ����һ�������ֵ  �����ѯ�ܵ�����   ��ѯĳ���˵�email
	  * @param connection
	  * @param sql
	  * @param args
	  * @return
	  * @throws SQLException
	  */
	<E> E getForValue(Connection connection,String sql,Object ...args) throws SQLException;
	/**
	  * ����һ��T���͵��б�  ���ص��Ƕ��ֵ
	  * @param connection
	  * @param sql
	  * @param args
	  * @return
	  * @throws SQLException
	  */
	 List<T> getForList(Connection connection,String sql,Object ...args) throws SQLException;
	
	 /**
	  * ��map����ʽ���������
	  * @param connection
	  * @param sql
	  * @param args
	  * @return
	  * @throws SQLException
	  */
	 Map<String, Object> getFoMap(Connection connection,String sql,Object...args) throws SQLException;
	 
	 /**
	  * ���ض���ֵ��ʱ��ÿһ��ʹ��map�洢
	  * @param connection
	  * @param sql
	  * @param args
	  * @return
	  * @throws SQLException
	  */
	 List<Map<String, Object>>  getForListMap(Connection connection,String sql,Object...args) throws SQLException;
	 
	 /**
	  * ����һ��T���͵Ķ���
	  * @param connection
	  * @param sql
	  * @param args
	  * @return
	  * @throws SQLException
	  */
	 T get(Connection connection,String sql,Object...args)throws SQLException;
	
	/**
	  * INSERT UPDATE DELETE������ʹ���������
	  * @param connection
	  * @param sql
	  * @param args
	  * @throws SQLException
	  */
	int update(Connection connection,String sql, Object ...args) throws Exception;

}
