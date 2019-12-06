package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.BaseDao;
import database.ProcedureDemo;
import entity.Fenlei;
import entity.News;
import entity.PageUtils;

/**
 * Servlet implementation class NewsServlet
 */
@WebServlet("/news")
public class NewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	BaseDao<Fenlei> baseDao = new BaseDao<Fenlei>();
    	String sql = "select title from fenlei";
    	List<Fenlei> list = baseDao.selectMany(sql, Fenlei.class);
    	// ���ݲ�ѯ�Ĳ�����չʾ�б���ҳ��ѯ
    	String selectVal = req.getParameter("fenlei");
    	String titleVal = req.getParameter("title");
    	Integer pageIndex = req.getParameter("pageIndex") == null ? 1
    			: Integer.parseInt(req.getParameter("pageIndex"));
    	int pageSize = 3;
    	String selection = ""; // �����ѯ�ַ���
    	if (selectVal == null || selectVal.equals("0")) {
    		if (titleVal != null && (!titleVal.trim().equals(""))) {
    			selection += " title = \"" + titleVal + "\" ";
    		}
    	} else {
    		selection += " fenlei = \"" + selectVal + "\" ";
    		if (titleVal != null && (!titleVal.trim().equals(""))) {
    			selection += " and title = \"" + titleVal + "\" ";
    		}
    	}
    	PageUtils<News> pu = new PageUtils<News>();
    	pu.setCondition(selection);
    	pageIndex = pageIndex < 1 ? 1 : pageIndex;
    	//pageIndex = pageIndex > totalPage ? totalPage : pageIndex;
    	pu.setCurrentPage(pageIndex);
    	pu.setPageSize(pageSize);
    	pu.setTableName("fz_news");
    	// ��ȡ��ҳ��ѯ�Ľ��
    	ProcedureDemo.procPaging(pu, News.class);
    	// ������ת����index2.jsp
    	req.setAttribute("pu", pu);
    	req.setAttribute("fenleiList", list);
    	req.setAttribute("fenlei", selectVal);
    	req.setAttribute("title", titleVal);
    	req.setAttribute("pageIndex", pageIndex);
    	req.getRequestDispatcher("index2.jsp").forward(req, resp);
    }

}
