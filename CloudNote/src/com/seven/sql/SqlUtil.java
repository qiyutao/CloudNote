package com.seven.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.seven.bean.UserBean;

public class SqlUtil {
	private Connection conn;
	private Statement stmt;
	
	public SqlUtil() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/cloudnote?" +
		                                   "user=root&password=123456&serverTimezone=UTC");
		    stmt = conn.createStatement();
		    
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean insertUser(UserBean user) {
		boolean canUse = false;
		String sql = "insert into User values(null,'" +
					user.getUserName()+"','"+
					user.getUserPasswd()+"','"+
					user.getUserEmail()+"',NOW())";
		System.out.println(stmt);
		System.out.println(sql);
		System.out.println("insert into User values(null,'a','12','sad',NOW())");
		
		try {
			//select * from user where uss='sdc'
			ResultSet set = stmt.executeQuery("select * from User where user_name='"+user.getUserName()+"'");
			if(!set.next()) {
				stmt.execute(sql);
				canUse = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return canUse;
	}
	
	public int valid(UserBean user) {
		//select * from User where us
		int id = 0;
		String sql = "select * from User where user_name='"+user.getUserName()+"'";
		try {
			ResultSet set = stmt.executeQuery(sql);
			if(set.next()) {
				if(set.getString("user_passwd").equals(user.getUserPasswd())) {
					id = set.getInt("user_id");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public void close() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/*public static void main(String[] args) {
		SqlUtil sql = new SqlUtil();
		try {
			sql.stmt.execute("insert into User values(null,'a','12','sad',NOW())");
			sql.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
