<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 使用传统方式获取作用域对象的数据 -->
<%-- 
<h3>传统方式获取作用域中的对象</h3>
<b><%=request.getParameter("uname") %></b><br/>
<b><%=request.getParameter("pwd") %></b><br/>
<b><%=request.getAttribute("str") %></b><br/>
<b><%=((User)request.getAttribute("user")).getAddr().getTown() %></b><br/>
<b><%=((List)request.getAttribute("list")).get(1) %></b><br/>
<b><%=((User)(((List)request.getAttribute("list2")).get(0))).getAddr().getTown()%></b><br/>
<b><%=((Map)(request.getAttribute("map"))).get("c")%></b><br/>
<b><%=((User)((Map)(request.getAttribute("map2"))).get("a1")).getAddr().getCity()%></b><br/>
--%>
<%--  
	传统方式获取作用域数据：
		缺点一：导入包
		缺点二：需要强转
		缺点三：获取数据的代码过于麻烦
--%>

<!-- 使用EL表达式获取作用域对象中的数据 -->
<h3>EL表达式学习，使用EL表达式获取作用域对象的数据</h3>
<b>${param.uname }</b><br/>
<b>${param.pwd }</b><br/>
<b>${paramValues.fav[0]}</b><br/>
<b>${str }</b><br/>
<b>${user.addr.town }</b><br/>
<b>${list[1] }</b><br/>
<b>${list2[0].addr.town }</b><br/>
<b>${map.c }</b><br/>
<b>${map2.a1.addr.city }</b><br/>
