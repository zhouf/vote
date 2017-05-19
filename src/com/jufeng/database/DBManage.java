package com.jufeng.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import com.sun.rowset.WebRowSetImpl;

public class DBManage {
	static int connCount = 0;

	/**
	 * 返回一个连接对象
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//根据连接配置获取数据库连接
			Class.forName("org.hsqldb.jdbcDriver").newInstance();
			
			//使用内存数据库
			conn = DriverManager.getConnection("jdbc:hsqldb:mem:votedb", "sa", "");
			
		} catch (Exception ex) {
			System.err.println("出现例外，信息是:" + ex.getMessage());
			ex.printStackTrace();
		}
		connCount++;
		return conn;
	}

	/**
	 * 在此处进行关闭连接的操作
	 */
	public static void closeConnection(Connection conn) {
		try {
			if (conn != null && conn.isClosed() == false) {
				conn.close();
			}
		} catch (SQLException ex) {
			System.err.println("出现例外，信息是:" + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (conn != null && conn.isClosed() == false) {
					conn.close();
				}
			} catch (SQLException e) {
				System.err.println("关闭conn时出现异常:" + e.toString());
				e.printStackTrace();
			}
			connCount--;
		}
	}

	/**
	 * 返回一个WebRowSet结果集
	 * 
	 * @param sql
	 *            传入SQL语句
	 * @return 返回通过SQL查询的结果集
	 */
	public static WebRowSet getWRS(String sql) {
		Connection conn = DBManage.getConnection();
		WebRowSet wrs = getWRS(conn, sql);
		DBManage.closeConnection(conn);
		return wrs;
	}

	/**
	 * 这是一个需要传入连接对象的方法,执行完成后不关闭连接对象
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 */
	public static WebRowSet getWRS(Connection conn, String sql) {
		WebRowSet wrs = null;
		try {
			ResultSet rs = conn.createStatement().executeQuery(sql);
			wrs = new WebRowSetImpl();
			wrs.populate(rs);
			rs.close();
		} catch (SQLException e) {
			System.err.println("get WRS error:" + e.toString());
			e.printStackTrace();
		}
		return wrs;
	}

	

	/**
	 * 这是一个SQL语句的方法
	 * 
	 * @param sql
	 * @return
	 */
	public static int doUpdate(String sql) {
		int retVal = 0;
		Connection conn = DBManage.getConnection();
		retVal = doUpdate(conn, sql);
		closeConnection(conn);
		return retVal;
	}

	/**
	 * 这是一个需要连接对象的方法
	 * 
	 * @param conn
	 * @param sql
	 * @return
	 */
	public static int doUpdate(Connection conn, String sql) {
		int retVal = 0;
		try {
			retVal = conn.createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.err.println("执行doUpdate()时出现异常" + e.toString());
		}
		return retVal;
	}

}
