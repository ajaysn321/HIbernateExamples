package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Car {

	@Id
	private int cid;
	
	private String cname;
	
	private String ctype;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCtype() {
		return ctype;
	}

	public void setCtype(String ctype) {
		this.ctype = ctype;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", cname=" + cname + ", ctype=" + ctype + "]";
	}
	
	
}
