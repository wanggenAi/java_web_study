<%@page import="listener.User2"%>
<%@page import="java.io.File"%>
<%@page import="java.util.UUID"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.FileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
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
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart == true) {
			// 创建 FileItemFactory 实例
			FileItemFactory factory = new DiskFileItemFactory();
			// 创建ServletFileUpload实例
			ServletFileUpload upload = new ServletFileUpload(factory);
			try {
				// 解析request请求中的数据
				List<FileItem> items = upload.parseRequest(request);
				Iterator<FileItem> iter = items.iterator();
				String userName = "";
				String password = "";
				while (iter.hasNext()) {
					FileItem item = iter.next();
					// 判断元素类型，是否是普通表单
					if (item.isFormField()) {
						// 获取普通表单元素名称
						String fieldName = item.getFieldName();
						if (fieldName.equals("userName")) {
							out.print("用户名是:" + item.getString("UTF-8") + "<br/>");
							userName = item.getString("UTF-8");
						} else if (fieldName.equals("password")) {
							out.print("密码是:" + item.getString());
							password = item.getString();
						}
					} else { // 文件上传
						String fileName = item.getName();
						if (fileName != null && !fileName.equals("")) {
							String suffix = fileName.substring(fileName.lastIndexOf(".")); // .jpg
							String uuid = UUID.randomUUID().toString();
							String savePath = request.getServletContext().getRealPath("/WEB-INF/upload");
							String newFileName = uuid + suffix;
							File saveDir = new File(savePath);
							if (!saveDir.exists()) {
								saveDir.mkdir();
							}
							File saveFile = new File(savePath, newFileName);
							item.write(saveFile);
						}
					}
				}
				User2 user = new User2(1, userName, password, "d5736208@qq.com");
				session.setAttribute("user", user);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	%>
</body>
</html>