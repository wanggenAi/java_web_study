package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		System.out.println(uname+':'+pwd);
		req.getRequestDispatcher("/el.jsp").forward(req, resp);
		return;
	}

}
