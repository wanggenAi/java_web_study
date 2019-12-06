<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index2</title>
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

<body>
	<!-- 每页显示2条，可以根据新闻分类、新闻标题，调用存储过程的方法执行分页查询 -->
	<form action="news">
		<label>新闻分类：</label><select name="fenlei">
			<option value="0">全部</option>
			<c:forEach items="${fenleiList }" var="fl">
				<c:choose>
					<c:when test="${fenlei==fl.title }">
						<option selected="selected">${fl.title }</option>
					</c:when>
					<c:otherwise>
						<option>${fl.title }</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> <label>新闻标题：</label><input type="text" name="title" id="title"
			value="${title }" /><input type="submit" value="GO" /> <input
			name="totalPage" type="hidden" value="${pu.totalPage}" />
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
			<c:forEach var="news" items="${pu.datas }">
				<tr>
					<td>${news.title }</td>
					<td>${news.fenlei }</td>
					<td>${news.adder }</td>
					<td>${news.addtime }</td>
					<td><a
						href='
					<c:url value="newsupdate">
						<c:param name="id" value="${news.id }"></c:param>
					</c:url>'>修改</a>&nbsp;&nbsp;<a
						href="<c:url value="newsdel">
						<c:param name="id" value="${news.id }"></c:param>
					</c:url>">删除</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	共 ${pu.totalNum }条记录&nbsp;&nbsp;${pageIndex }/${pu.totalPage }
	<a
		href='<c:url value="news"><c:param name="pageIndex" value="1"></c:param></c:url>'>首页</a>
	<a
		href='<c:url value="news"><c:param name="pageIndex" value="${pageIndex - 1 }"></c:param></c:url>'>上一页</a>
	<a
		href='<c:url value="news"><c:param name="pageIndex" value="${pageIndex = pageIndex + 1>pu.totalPage?pu.totalPage:pageIndex+1 }"></c:param></c:url>'>下一页</a>
	<a
		href='<c:url value="news"><c:param name="pageIndex" value="${pu.totalPage }"></c:param></c:url>'>末页</a>
	<%-- 共
	<%=pu.getTotalNum()%>记录 &nbsp;&nbsp;<%=pageIndex%>/<%=pu.getTotalPage()%>
	<a href="index.jsp?pageIndex=1">首页</a>
	<a href="index.jsp?pageIndex=<%=pageIndex - 1%>">上一页</a>
	<a href="index.jsp?pageIndex=<%=pageIndex = pageIndex + 1 > pu.getTotalPage() ? pu.getTotalPage() : pageIndex + 1 %>">下一页</a>
	<a href="index.jsp?pageIndex=<%=pu.getTotalPage()%>">末页</a>--%>
	<hr />
	${info }
</body>
</html>