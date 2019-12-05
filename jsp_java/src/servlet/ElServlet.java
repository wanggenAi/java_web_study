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
 * ��Servlet�����������ʹ�������������Ϊ������ת�����壬������ת����Ӧ��jsp�ļ� Ҫ�����jsp�л�ȡ�������е������أ� ʹ�ã�
 * ��ͳ��ʽ����jspҳ����ʹ��Java�ű������
 * 
 * @author ����
 *
 */
@WebServlet("/es")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ������������ʽ
		req.setCharacterEncoding("utf-8");
		// ������Ӧ�����ʽ
		resp.setContentType("text/html;charset=utf-8");
		// ��ȡ������Ϣ
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		// ����������Ϣ
		System.out.println(uname + ':' + pwd);
		// ʹ��request���������������ת
		req.setAttribute("str", "�и������С��");
		User u = new User(1, "����", "�ĵ�Ӱ", new Address("����", "����", "�ݳ���"));
		req.setAttribute("user", u);
		// �������ͣ�
		List<String> list = new ArrayList<String>();
		list.add("����");
		list.add("��ʫʫ");
		list.add("�����");
		User u2 = new User(1, "��������", "�ĵ�Ӱ", new Address("�½�", "��³ľ��", "��³ľ��"));
		List<User> list2 = new ArrayList<User>();
		list2.add(u2);
		req.setAttribute("list", list);
		req.setAttribute("list2", list2);
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "����");
		map.put("b", "�Ϻ�");
		map.put("c", "����");
		req.setAttribute("map", map);
		Map<String, User> map2 = new HashMap<String, User>();
		map2.put("a1", new User(3,"����","����Ӱ",new Address("�½�","��³��", "��³��")));
		req.setAttribute("map2", map2);
		req.getRequestDispatcher("/JstlTest.jsp").forward(req, resp);
		return;
	}

}
