package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在Servlet进行请求处理后，使用作用域对象作为数据流转的载体，将数据转给对应的jsp文件 要如何在jsp中获取作用域中的数据呢？ 使用：
 * 传统方式：在jsp页面中使用Java脚本段语句
 * 
 * @author 王根
 *
 */
@WebServlet("/es")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置请求编码格式
		req.setCharacterEncoding("utf-8");
		// 设置响应编码格式
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求信息
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		// 处理请求信息
		System.out.println(uname+':'+pwd);
		req.getRequestDispatcher("/el.jsp").forward(req, resp);
		return;
	}

}
