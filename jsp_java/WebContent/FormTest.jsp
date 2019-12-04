<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
    window.onload = function()
    {
        CKEDITOR.replace( 'description');
    };
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="doForm.jsp" method="post" enctype="multipart/form-data">
		<label>用户名：</label><input type="text" name="userName"/> <br/>
		<label>密码：</label><input type="password" name="password"/> <br/>
		<input type="file" name="name"/>
		<textarea name="description" id="description"/></textarea>
    	<input type="submit" value="提交">
	</form>
</body>


</html>