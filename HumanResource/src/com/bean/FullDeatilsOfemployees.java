package com.bean;

public class FullDeatilsOfemployees {

	private int eid;
	private String ename;
	private String email;
	private String password;
	private int deptId;
	private String dname;
	private String dlocation;

	public FullDeatilsOfemployees() {

	}

	public FullDeatilsOfemployees(int eid, String ename, String email, String password, int deptId, String dname,
			String dlocation) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.email = email;
		this.password = password;
		this.deptId = deptId;
		this.dname = dname;
		this.dlocation = dlocation;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDlocation() {
		return dlocation;
	}

	public void setDlocation(String dlocation) {
		this.dlocation = dlocation;
	}

	@Override
	public String toString() {
		return "FullDeatilsOfemployees [eid=" + eid + ", ename=" + ename + ", email=" + email + ", password=" + password
				+ ", deptId=" + deptId + ", dname=" + dname + ", dlocation=" + dlocation + "]";
	}

}
