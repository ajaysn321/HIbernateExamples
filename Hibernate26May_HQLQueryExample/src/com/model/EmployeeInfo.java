package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmployeeInfo {
	
	@Id
	private int eid;
	
	private String ename;
	
	private String address;
	
	private double salary;
	
	private Date  joinnigDate;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getJoinnigDate() {
		return joinnigDate;
	}

	public void setJoinnigDate(Date joinnigDate) {
		this.joinnigDate = joinnigDate;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [eid=" + eid + ", ename=" + ename + ", address=" + address + ", salary=" + salary
				+ ", joinnigDate=" + joinnigDate + "]";
	}

	
	
}
