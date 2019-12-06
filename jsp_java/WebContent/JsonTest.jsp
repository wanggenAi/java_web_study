<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>json对象</title>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 定义json对象并在div中输出
		var user = {"id":1, "name":"张三", "pwd":"000"};
		$("#objectDiv").append("ID:"+user.id+"<br/>").append("用户名："+user.name+"<br/>").
			append("密码："+user.pwd+"<br/>");
		
		// 定义字符换数组，循环添加到ul和select对象中
		var ary = ["中","美","俄"];
		$ary = $(ary);
		$ul = $("#arrayUL");
		$sel = $("#arraySel");
		$ary.each(function(){
			$ul.append("<li>"+this+"</li>");
		});
		$ary.each(function(i){
			$sel.append("<option value='"+i+"'>"+this+"</option>");
		});
		// 定义JSON格式的user对象数组，并使用<table>输出
		var userArray = [{
			"id":2,
			"name":"admin",
			"pwd":"123"
			
		},{
			"id":3,
			"name":"詹姆斯",
			"pwd":"1111",
		},{
			"id":4,
			"name":"梅西",
			"pwd":"6666"
		}];
		
		var $table = $("<table border='1'></table").append(
			"<tr><td>ID</td><td>用户名</td><td>密码</td></tr>"		
		).appendTo("#objectDiv")
		
		$(userArray).each(function(){
			$table.append("<tr><td>"+this.id+"</td><td>"+this.name+"</td><td>"+this.pwd+"</td></tr>")
		})
	})
</script>
</head>
<body>
	<div id="objectDiv">
		<ul id="arrayUL"></ul>
		<select id="arraySel"></select>
	</div>
</body>
</html>