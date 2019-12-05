<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 
	JSTL 学习：
		作用：
			提高在jsp中逻辑代码的编写效率，使用标签。
		使用：
			JSTL的核心标签库
			JSTL的格式化标签库
			JSTL的SQL标签库
			JSTL的函数标签库
			JSTL的XML标签库
		JSTL的核心标签库：
			1、导入jar包
			2、声明JSTL标签库的引入（核心标签库）
			3、内容
				基本标签：
					<c:out value="数据" defalt="默认值"></c:out>
					数据可以为常量值也可以是EL表达式 作用:将数据输出给客户端
			
--%>
<c:out value="哈哈"></c:out><br/>
<c:out value="${str }"></c:out><br/>
<c:set var="hello" value="hello PageContext"></c:set><br/>
<c:set var="hello" value="hello Application" scope="application"></c:set>
<c:remove var="hello" scope=""></c:remove>
<c:out value="${hello}"></c:out><br/>