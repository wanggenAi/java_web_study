package servlet.listener;

import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

import util.JDBCUtil;

public class DataSourceListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		try {
			// ��ʼ��������
			Context cxt = new InitialContext();
			// ��ȡ���߼�������������Դ����
			JDBCUtil.ds = (DataSource) cxt.lookup("java:comp/env/jdbc/news");
			System.out.println("��ʼ������Դ.....");
		} catch (NamingException e) {
			e.printStackTrace();
		} 
	}

}
