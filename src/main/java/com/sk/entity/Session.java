package com.sk.entity;

public class Session {

	private Integer id;
	private User user;
	private String dateOpened;
	private String dateClosed;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDateOpened() {
		return dateOpened;
	}

	public void setDateOpened(String dateOpened) {
		this.dateOpened = dateOpened;
	}

	public Session() {
	}

	public Session(Integer id, User userId, String date_opened, String date_closed) {

		this.id = id;
		this.user = userId;
		this.dateOpened = date_opened;
		this.dateClosed = date_closed;
	}

	public String getDateClosed() {
		return dateClosed;
	}

	public void setDateClosed(String dateClosed) {
		this.dateClosed = dateClosed;
	}
}
