package com.bean;

public class Leave {

	private int id;
	private String ename;
	private int days;
	private String status;

	public Leave() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leave(int id, String ename, int days, String status) {
		super();
		this.id = id;
		this.ename = ename;
		this.days = days;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Leave [id=" + id + ", ename=" + ename + ", days=" + days + ", status=" + status + "]";
	}

}
