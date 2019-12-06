package database;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.Comment;
import entity.News;
import entity.PageUtils;
import util.JDBCUtil;
import util.StringUtil;

public class ProcedureDemo {
	public static <T> PageUtils<T> procPaging(PageUtils<T> pu, Class<T> cls) {
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConn();
//			Class.forName("com.mysql.jdbc.Driver");
//			conn = DriverManager.getConnection("jdbc:mysql://192.168.208.3:3306/news", "root", "123456");
			cs = conn.prepareCall("{call pro_page2 (?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, pu.getTableName());
			cs.setString(2, pu.getSelections());
			cs.setString(3, pu.getCondition());
			cs.setString(4, pu.getSortColumn());
			cs.setString(5, pu.getSortType());
			cs.setInt(6, pu.getCurrentPage());
			cs.setInt(7, pu.getPageSize());

			// 注册输出参数
			cs.registerOutParameter(8, java.sql.Types.INTEGER);
			cs.registerOutParameter(9, java.sql.Types.INTEGER);
			cs.execute();
			// 获取指定位置的输出参数集
			int totalPage = cs.getInt(8);
			int totalNum = cs.getInt(9);
			pu.setTotalPage(totalPage);
			pu.setTotalNum(totalNum);
			// 存储所得的结果集
			List<T> list = new ArrayList<>();
			
			rs = cs.getResultSet();
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取数据总列数
			int count = rsmd.getColumnCount();
			while (rs.next()) {
				T obj = cls.newInstance();
				for (int i = 1; i <= count; i++) {
					String columnlabel = rsmd.getColumnLabel(i); // 获取字段名称，一定要和实体类的属性名对应好，实体类中的属性名应当全部小写
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
			pu.setDatas(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cs != null) {
				try {
					cs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			JDBCUtil.close(rs, null, conn);
		}
		return pu;
	}
}

class Test {
	public static void main(String[] args) {
		PageUtils<News> pu = new PageUtils<News>();
		pu.setCurrentPage(2);
		pu.setPageSize(1);
		pu.setTableName("fz_news");
		ProcedureDemo.procPaging(pu, News.class);
		for (News news : pu.getDatas()) {
			System.out.println(news.getTitle());
		}
		PageUtils<Comment> cpu = new PageUtils<Comment>();
		cpu.setCurrentPage(2);
		cpu.setPageSize(1);
		cpu.setTableName("pl");
		ProcedureDemo.procPaging(cpu, Comment.class);
		for (Comment co : cpu.getDatas()) {
			System.out.println(co.getContent());
		}
	}
}
