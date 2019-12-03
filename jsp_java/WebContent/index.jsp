<%@page import="entity.News"%>
<%@page import="java.util.List"%>
<%@page import="service.NewsServiceImp"%>
<%@page import="dao.NewsDaoImp"%>
<%@page import="dao.NewsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		NewsDao newsDao = new NewsDaoImp();
		NewsServiceImp ns = new NewsServiceImp();
		ns.setNewsDao(newsDao);
		List<News> list = ns.findAll("select * from fz_news limit 3", News.class);
		for (News news : list) {
			out.print(news.getTitle()+"<br/>");
		}
	%>
</body>
</html>