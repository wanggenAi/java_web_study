package dao;

import java.util.List;

import database.BaseDao;
import entity.News;

public class NewsDaoImp extends BaseDao<News> implements NewsDao {

	@Override
	public List<News> findAll(String sql, Class<News> cls, Object... args) {
		// TODO Auto-generated method stub
		return selectMany(sql, cls, args);
	}

	@Override
	public News findOne(String sql, Class<News> cls, Object... args) {
		// TODO Auto-generated method stub
		return selectOne(sql, cls, args);
	}

	@Override
	public int findCount(String sql, Object... args) {
		// TODO Auto-generated method stub
		return selectCount(sql, args);
	}

}
