package com.seven.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seven.bean.UserBean;
import com.seven.sql.SqlUtil;

/**
 * Servlet implementation class RegistServlet
 */
@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		boolean canUse = setUserBean(request);
		//response.getWriter().append("<script language='javascript'>alert(\"注册成功，返回登陆\")</script>");
		if(canUse)
			response.getWriter().append("<script>alert('regist succeed,back login');history.back();</script>");
		//response.sendRedirect("login.jsp");
		else {
			response.getWriter().append("<script>alert('username already used,change other username');</script>");
			response.sendRedirect("login.jsp");
		}
	}

	private boolean setUserBean(HttpServletRequest request) {
		// TODO Auto-generated method stub
		UserBean user = new UserBean();
		user.setUserName(request.getParameter("username"));
		user.setUserPasswd(request.getParameter("password"));
		user.setUserEmail(request.getParameter("email"));
		
		boolean canUse = insertRegist(user);
		
		System.out.println(user.getUserName());
		System.out.println(user.getUserPasswd());
		System.out.println(user.getUserEmail());
		
		return canUse;
	}

	private boolean insertRegist(UserBean user) {
		// TODO Auto-generated method stub
		SqlUtil sql = new SqlUtil();
		boolean canUse = sql.insertUser(user);
		sql.close();
		return canUse;
	}

}
