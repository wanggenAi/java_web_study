package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCUtil {
	private static Connection conn = null;
	private static DataSource ds = null;
	static {
		try {
			// 初始化上下文
			Context cxt = new InitialContext();
			// 获取与逻辑名关联的数据源对象
			ds = (DataSource) cxt.lookup("java:comp/env/jdbc/news");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
