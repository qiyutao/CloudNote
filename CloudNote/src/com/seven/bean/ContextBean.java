package com.seven.bean;

import java.sql.Time;

public class ContextBean {
	private int noteId;
	private int userId;
	private String noteTitle;
	private String noteContext;
	private String noteDate;
	
	public ContextBean() {
		noteId = 0;
		userId = 0;
		noteTitle = null;
		noteContext = null;
		noteDate = null;
	}

	/**
	 * @return the noteId
	 */
	public int getNoteId() {
		return noteId;
	}

	/**
	 * @param noteId the noteId to set
	 */
	public void setNoteId(int noteId) {
		this.noteId = noteId;
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
	 * @return the noteTitle
	 */
	public String getNoteTitle() {
		return noteTitle;
	}

	/**
	 * @param noteTitle the noteTitle to set
	 */
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}

	/**
	 * @return the noteContext
	 */
	public String getNoteContext() {
		return noteContext;
	}

	/**
	 * @param noteContext the noteContext to set
	 */
	public void setNoteContext(String noteContext) {
		this.noteContext = noteContext;
	}

	/**
	 * @return the noteDate
	 */
	public String getNoteDate() {
		return noteDate;
	}

	/**
	 * @param noteDate the noteDate to set
	 */
	public void setNoteDate(String noteDate) {
		this.noteDate = noteDate;
	}
	
	
}
