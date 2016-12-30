package com.seven.bean;

public class UserBean {
	private int userId;
	private String userName;
	private String userPasswd;
	private String userEmail;
	private String userTime;
	
	public UserBean() {
		userId = 0;
		userName = null;
		userPasswd = null;
		userEmail = null;
		userTime = null;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPasswd
	 */
	public String getUserPasswd() {
		return userPasswd;
	}

	/**
	 * @param userPasswd the userPasswd to set
	 */
	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userTime
	 */
	public String getUserTime() {
		return userTime;
	}

	/**
	 * @param userTime the userTime to set
	 */
	public void setUserTime(String userTime) {
		this.userTime = userTime;
	}
	
	
}
