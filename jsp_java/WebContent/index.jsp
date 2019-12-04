<%@page import="java.util.ArrayList"%>
<%@page import="database.ProcedureDemo"%>
<%@page import="entity.News"%>
<%@page import="entity.PageUtils"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="entity.Fenlei"%>
<%@page import="database.BaseDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
<style type="text/css">
table tr {
	text-align: "center";
}

td {
	text-align: center;
}

tr:nth-child(odd) td {
	background-color: #AAAAAA;
}
</style>
</head>

<%
	BaseDao<Fenlei> baseDao = new BaseDao<Fenlei>();
	String sql = "select title from fenlei";
	List<Fenlei> list = baseDao.selectMany(sql, Fenlei.class);
	// 根据查询的参数，展示列表，分页查询
	String selectVal = request.getParameter("fenlei");
	String titleVal = request.getParameter("title");
	Integer pageIndex = request.getParameter("pageIndex") == null ? 1
			: Integer.parseInt(request.getParameter("pageIndex"));
	int pageSize = 3;
	String selection = ""; // 定义查询字符串
	if (selectVal == null || selectVal.equals("0")) {
		if (titleVal != null && (!titleVal.trim().equals(""))) {
			selection += " title = \"" + titleVal + "\" ";
		}
	} else {
		selection += " fenlei = \"" + selectVal + "\" ";
		if (titleVal != null && (!titleVal.trim().equals(""))) {
			selection += " and title = \"" + titleVal + "\" ";
		}
	}
	PageUtils<News> pu = new PageUtils<News>();
	pu.setCondition(selection);
	pageIndex = pageIndex < 1 ? 1 : pageIndex;
	//pageIndex = pageIndex > totalPage ? totalPage : pageIndex;
	pu.setCurrentPage(pageIndex);
	pu.setPageSize(pageSize);
	pu.setTableName("fz_news");
	ProcedureDemo.procPaging(pu, News.class);
	// 获取分页查询的结果
	List<News> newsList = pu.getDatas() == null ? new ArrayList<News>() : pu.getDatas();
%>


<body>
	<!-- 每页显示2条，可以根据新闻分类、新闻标题，调用存储过程的方法执行分页查询 -->
	<form action="index.jsp">
		<label>新闻分类：</label><select name="fenlei">
			<option value="0">全部</option>
			<%
				for (Fenlei obj : list) {
					if (selectVal != null && selectVal.equals(obj.getTitle())) {
						out.print("<option value=\"" + obj.getTitle() + "\" selected=\"selected\">" + obj.getTitle()
								+ "</option>");
					} else {
						out.print("<option value=\"" + obj.getTitle() + "\">" + obj.getTitle() + "</option>");
					}
				}
			%>
		</select> <label>新闻标题：</label><input type="text" name="title" id="title"
			value="<%=titleVal == null ? "" : titleVal%>" /><input type="submit"
			value="GO" /> <input name="totalPage" type="hidden"
			value="<%=pu.getTotalPage()%>" />
	</form>
	<table width="70%" border="1px" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th>新闻标题</th>
				<th>分类</th>
				<th>作者</th>
				<th>时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (News news : newsList) {
					String str = "<tr><td>" + news.getTitle() + "</td><td>" + news.getFenlei() + "</td><td>"
							+ news.getAdder() + "</td><td>" + news.getAddtime()
							+ "</td><td><a href='#'>修改    </a><a href='#'>删除</a></td></tr>";
					out.print(str);
				}
			%>
		</tbody>
	</table>
	共
	<%=pu.getTotalNum()%>记录 &nbsp;&nbsp;<%=pageIndex%>/<%=pu.getTotalPage()%>
	<a href="index.jsp?pageIndex=1">首页</a>
	<a href="index.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>
	<a
		href="index.jsp?pageIndex=<%=pageIndex = pageIndex + 1 > pu.getTotalPage() ? pu.getTotalPage() : pageIndex + 1 %>">下一页</a>
	<a href="index.jsp?pageIndex=<%=pu.getTotalPage()%>">末页</a>
</body>
</html>