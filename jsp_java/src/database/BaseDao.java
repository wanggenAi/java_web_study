package database;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;
import util.StringUtil;

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
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				T obj = cls.newInstance(); // 创建cls实例
				// 获取数据库表的字段数
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String columnlabel = metaData.getColumnLabel(i); // 获取字段名称，一定要和实体类的属性名对应好，实体类中的属性名应当全部小写
					String name = "set" + StringUtil.toUpper(columnlabel);
					Field field = cls.getDeclaredField(columnlabel);
					Method method = cls.getMethod(name, field.getType());
					// 先获取改行此列的值
					Object realParam = rs.getObject(columnlabel);
					// 给这个对象赋值
					method.invoke(obj, realParam);
				}
				list.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return list;
	}

	/**
	 * 查询总记录数
	 */
	public int selectCount(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JDBCUtil.getConn();
			pst = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				pst.setObject(i + 1, args[i]);
			}
			rs = pst.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return count;
	}

}
