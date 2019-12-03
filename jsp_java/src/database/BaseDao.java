package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.JDBCUtil;

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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pst, conn);
		}
		return list;
	}

}
