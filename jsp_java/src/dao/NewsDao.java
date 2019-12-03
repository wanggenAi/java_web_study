package dao;

import java.util.List;

import entity.News;

public interface NewsDao {
	int executeUpdate(String sql, Object... args); // 新闻增删改的方法

	List<News> findAll(String sql, Class<News> cls, Object... args); // 查询所有的方法

	News findOne(String sql, Class<News> cls, Object... args); // 返回一个对象
	
	int findCount(String sql, Object... args); // 返回查询的总行数
}
