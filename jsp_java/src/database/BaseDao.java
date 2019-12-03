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
 * ��װJDBC����ɾ�Ĳ鹦��
 * 
 * @author Administrator
 *
 * @param <T>
 */
public class BaseDao<T> {

	/**
	 * ��װ��ɾ�Ĺ���
	 * 
	 * @param sql
	 *            ��Ҫִ�е�sql���
	 * @param args
	 *            �����������Ƕ�sql����ռλ������Ĳ���
	 * @return ���ز�����Ӱ�쵽����
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
	 * ��ѯһ����¼
	 * 
	 * @param sql
	 *            ��Ҫִ�е�sql
	 * @param cls
	 *            �ɴ�Class����ģ���������
	 */
	public T selectOne(String sql, Class<T> cls, Object... args) {
		List<T> list = this.selectMany(sql, cls, args);
		return list.isEmpty() ? null : list.get(0);
	}

	/**
	 * ��ѯ���м�¼
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
			// �ӽ���л�ȡ���ݿ��������Ϣ
			ResultSetMetaData metaData = rs.getMetaData();
			while (rs.next()) {
				T obj = cls.newInstance(); // ����clsʵ��
				// ��ȡ���ݿ����ֶ���
				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String columnlabel = metaData.getColumnLabel(i); // ��ȡ�ֶ����ƣ�һ��Ҫ��ʵ�������������Ӧ�ã�ʵ�����е�������Ӧ��ȫ��Сд
					String name = "set" + StringUtil.toUpper(columnlabel);
					Field field = cls.getDeclaredField(columnlabel);
					Method method = cls.getMethod(name, field.getType());
					// �Ȼ�ȡ���д��е�ֵ
					Object realParam = rs.getObject(columnlabel);
					// ���������ֵ
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
	 * ��ѯ�ܼ�¼��
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
