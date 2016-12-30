package com.seven.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.bean.ContextBean;
import com.seven.sql.SqlUtil;

/**
 * Servlet implementation class OperationServlet
 */
@WebServlet("/OperationServlet")
public class OperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OperationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ContextBean> list = (List<ContextBean>) request.getSession().getAttribute("notelist");
		int index = Integer.parseInt(request.getParameter("count"));
		ContextBean bean = list.get(index);
		
		int userId = bean.getUserId();
		int noteId = bean.getNoteId();
		request.getSession().setAttribute("notelist", null);
		if(request.getParameter("op").equals("del")) {
			SqlUtil util = new SqlUtil();
			util.delete(userId, noteId);
			util.close();
			response.sendRedirect("index.jsp");
		} else {
			request.getSession().setAttribute("notebean", bean);
			response.sendRedirect("edit.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		ContextBean contextBean = (ContextBean) request.getSession().getAttribute("notebean");
		setBean(contextBean,request);
		
		insert(contextBean);
		request.getSession().setAttribute("notebean", null);
		response.sendRedirect("index.jsp");
	}
	
	private void insert(ContextBean contextBean) {
		// TODO Auto-generated method stub
		SqlUtil util = new SqlUtil();
		util.update(contextBean);
		util.close();
	}

	private void setBean(ContextBean contextBean, HttpServletRequest request) {
		// TODO Auto-generated method stub
		//System.out.println(request.getSession().getAttribute("user_id"));
		//String id = request.getSession().getAttribute("user_id").toString();
		//contextBean.setUserId(Integer.parseInt(id));
		contextBean.setNoteTitle(request.getParameter("text"));
		contextBean.setNoteContext(request.getParameter("textarea"));
		
		
	}

}
