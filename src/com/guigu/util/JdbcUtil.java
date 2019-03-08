package com.guigu.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 使用数据库连接池的形式获得连接
 * @author TX401JS
 *
 */
public class JdbcUtil {
	
	private static  ComboPooledDataSource  dataSource;
	static {
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream("src/com/guigu/mysql-jdbc.properties"));
			dataSource = new ComboPooledDataSource();
			dataSource.setUser(pro.getProperty("user"));
			dataSource.setPassword(pro.getProperty("password"));
			dataSource.setDriverClass(pro.getProperty("driverName"));
			dataSource.setJdbcUrl(pro.getProperty("url"));
			dataSource.setMaxPoolSize(100);
			dataSource.setMinPoolSize(20);
			dataSource.setInitialPoolSize(20);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * 获得数据库连接的方法
	 * @return  数据库的连接对象
	 */
	public  static Connection  getConn() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
