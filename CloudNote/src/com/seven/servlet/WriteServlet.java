package com.seven.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.bean.ContextBean;
import com.seven.sql.SqlUtil;

/**
 * Servlet implementation class WriteServlet
 */
@WebServlet("/WriteServlet")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		ContextBean contextBean = new ContextBean();
		setBean(contextBean,request);
		
		insert(contextBean);
		response.sendRedirect("index.jsp");
	}

	private void insert(ContextBean contextBean) {
		// TODO Auto-generated method stub
		SqlUtil util = new SqlUtil();
		util.insertContext(contextBean);
		util.close();
	}

	private void setBean(ContextBean contextBean, HttpServletRequest request) {
		// TODO Auto-generated method stub
		System.out.println(request.getSession().getAttribute("user_id"));
		String id = request.getSession().getAttribute("user_id").toString();
		contextBean.setUserId(Integer.parseInt(id));
		contextBean.setNoteTitle(request.getParameter("text"));
		contextBean.setNoteContext(request.getParameter("textarea"));
		
		
	}

}
