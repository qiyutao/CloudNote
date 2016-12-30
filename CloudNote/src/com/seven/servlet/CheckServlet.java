package com.seven.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seven.bean.UserBean;
import com.seven.sql.SqlUtil;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
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
		
		int ok = setUser(request);
		if(ok>0) {
			HttpSession session = request.getSession(false);
			session.setAttribute("user_id", ok);
			session.setAttribute("user_name", request.getParameter("username"));
			response.getWriter().append("<script>alert('login successd!');</script>");
			response.sendRedirect("index.jsp");
		} else {
			response.getWriter().append("<script>alert('username or passwd is false');</script>");
			response.sendRedirect("login.jsp");
		}
	}

	private int setUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		user.setUserName(request.getParameter("username"));
		user.setUserPasswd(request.getParameter("password"));
		
		SqlUtil sqlUtil = new SqlUtil();
		int id = sqlUtil.valid(user);
		sqlUtil.close();
		
		return id;
	}

}
