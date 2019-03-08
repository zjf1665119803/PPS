package com.guigu.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.guigu.dao.BaseDao;

public class BaseDaoImpl<T> implements BaseDao<T>{
	
	//定义一个QueryRunner对象
	private QueryRunner  queryRunner = null;
	
	//创建的是T类型的Class对象
	private Class<T>  clazz = null;
	
	public BaseDaoImpl() {
		queryRunner = new QueryRunner();
		// 利用反射得到该类的类型
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		clazz = (Class) params[0];
	}

	@Override
	public int[] batch(Connection connection, String sql, Object[]... args) throws SQLException {
		return queryRunner.batch(connection, sql, args);
	}

	@Override
	public <E> E getForValue(Connection connection, String sql, Object... args) throws SQLException {
		return queryRunner.query(connection, sql, new ScalarHandler<>(),args );
	}

	@Override
	public List<T> getForList(Connection connection, String sql, Object... args) throws SQLException {
		return queryRunner.query(connection,sql,new BeanListHandler<T>(clazz),args);
	}

	@Override
	public T get(Connection connection, String sql, Object... args) throws SQLException {
		return queryRunner.query(connection,sql,new BeanHandler<T>(clazz),args);
	}

	@Override
	public int update(Connection connection, String sql, Object... args) throws Exception {
		return queryRunner.update(connection, sql, args);
	}

	@Override
	public Map<String, Object> getFoMap(Connection connection, String sql, Object... args) throws SQLException {
		return queryRunner.query(connection, sql,new MapHandler(),args);
	}

	@Override
	public List<Map<String, Object>> getForListMap(Connection connection, String sql, Object... args)
			throws SQLException {
		return queryRunner.query(connection, sql,new MapListHandler(),args);
	}

}
