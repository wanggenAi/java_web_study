package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

/**
 * 封装JDBC的增删改查功能
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class BaseDao<T> {

	/**
	 * 封装增删改功能
	 * 
	 * @param sql
	 *            需要执行的sql语句
	 * @param args
	 *            不定参数，是对sql语句的占位符传入的参数
	 * @return 返回操作所影响到行数
	 */
	public int executeUpdate(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement pst = null;
		int rows = 0;
		try {
			conn = JDBCUtil.getConn();
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i + 1, args[i]);
			}
			rows = pst.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(null, pst, conn);
		}
		return rows;
	}

	/**
	 * 查询一条记录
	 * 
	 * @param sql
	 *            需要执行的sql
	 * @param cls
	 *            由此Class对象建模的类的类型
	 */
	public T selectOne(String sql, Class<T> cls, Object... args) {
		List<T> list = this.selectMany(sql, cls, args);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * 查询所有记录
	 */
	public List<T> selectMany(String sql, Class<T> cls, Object... args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		try {
			conn = JDBCUtil.getConn();
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i + 1, args[i]);
			}
			rs = pst.executeQuery();
			// 从结果中获取数据库表的相关信息
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return list;
	}

}
