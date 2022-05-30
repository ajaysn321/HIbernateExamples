package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Simcard {

	@Id
	private int sid;
	
	private String sname;
	
	private String simtype;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSimtype() {
		return simtype;
	}

	public void setSimtype(String simtype) {
		this.simtype = simtype;
	}

	@Override
	public String toString() {
		return "Simcard [sid=" + sid + ", sname=" + sname + ", simtype=" + simtype + "]";
	}
	
	
}
