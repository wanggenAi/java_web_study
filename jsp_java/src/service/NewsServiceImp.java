package service;

import java.util.List;

import dao.NewsDao;
import entity.News;

public class NewsServiceImp implements NewsService {
	private NewsDao newsDao;
	public NewsDao getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDao newsDao) {
		this.newsDao = newsDao;
	}

	@Override
	public int executeUpdate(String sql, Object... args) {
		// TODO Auto-generated method stub
		return newsDao.executeUpdate(sql, args);
	}

	@Override
	public List<News> findAll(String sql, Class<News> cls, Object... args) {
		// TODO Auto-generated method stub
		return newsDao.findAll(sql, cls, args);
	}

	@Override
	public News findOne(String sql, Class<News> cls, Object... args) {
		// TODO Auto-generated method stub
		return newsDao.findOne(sql, cls, args);
	}

	@Override
	public int findCount(String sql, Object... args) {
		// TODO Auto-generated method stub
		return newsDao.findCount(sql, args);
	}
}

/*class Test {
	public static void main(String[] args) {
		NewsDao newsDao = new NewsDaoImp();
		NewsServiceImp ns = new NewsServiceImp();
		ns.setNewsDao(newsDao);
		List<News> list = ns.findAll("select * from fz_news limit 1", News.class);
		for (News news : list) {
			System.out.println(news.getTitle());
		}
	}
}*/
