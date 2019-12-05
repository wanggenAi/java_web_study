package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Address;
import entity.User;

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
		System.out.println(uname + ':' + pwd);
		// 使用request作用域进行数据流转
		req.setAttribute("str", "有个姑娘叫小芳");
		User u = new User(1, "柳岩", "拍电影", new Address("河南", "商丘", "虞城县"));
		req.setAttribute("user", u);
		// 集合类型：
		List<String> list = new ArrayList<String>();
		list.add("张三");
		list.add("刘诗诗");
		list.add("武大郎");
		User u2 = new User(1, "古力娜扎", "拍电影", new Address("新疆", "乌鲁木齐", "乌鲁木齐"));
		List<User> list2 = new ArrayList<User>();
		list2.add(u2);
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "北京");
		map.put("b", "上海");
		map.put("c", "徐州");
		req.setAttribute("map", map);
		Map<String, User> map2 = new HashMap<String, User>();
		map2.put("a1", new User(3,"丽丽","看电影",new Address("新疆","吐鲁番", "吐鲁番")));
		req.setAttribute("map2", map2);
		req.getRequestDispatcher("/JstlTest.jsp").forward(req, resp);
		return;
	}

}
