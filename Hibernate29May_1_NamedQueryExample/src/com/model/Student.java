package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
@NamedQuery(name = "findall",query = "from Student"),
@NamedQuery(name = "fetchSingle",query = "from Student where sid=:id"),
@NamedQuery(name = "updateStudent",query = "update Student set sname=:n,saddress=:a where sid=:id")
})
public class Student {
	
	@Id
	private int sid;
	
	private String sname;
	
	private String saddress;

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

	public String getSaddress() {
		return saddress;
	}

	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + "]";
	}
	
	

}
