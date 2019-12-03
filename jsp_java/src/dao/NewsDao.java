package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	int executeUpdate(String sql, Object... args); // ������ɾ�ĵķ���

	List<News> findAll(String sql, Class<News> cls, Object... args); // ��ѯ���еķ���

	News findOne(String sql, Class<News> cls, Object... args); // ����һ������
	
	int findCount(String sql, Object... args); // ���ز�ѯ��������
}
