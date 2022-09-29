package com.bean;

public class Department {

	private int id;
	private String dname;
	private String location;

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String dname, String location) {
		super();
		this.id = id;
		this.dname = dname;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", dname=" + dname + ", location=" + location + "]";
	}

}
