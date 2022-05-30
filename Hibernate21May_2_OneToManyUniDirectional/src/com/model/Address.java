package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "address_21May")
public class Address implements Comparable<Address>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	
	private String firstLine;
	
	private String secondLine;
	
	private int pinCode;
	
	@ManyToOne
	@JoinColumn(name= "user_id")
	private UserOneToMany user;
	

	public int getAddId() {
		return addId;
	}

	public void setAddId(int addId) {
		this.addId = addId;
	}

	public String getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}

	public String getSecondLine() {
		return secondLine;
	}

	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [addId=" + addId + ", firstLine=" + firstLine + ", secondLine=" + secondLine + ", pinCode="
				+ pinCode + "]";
	}

	@Override
	public int compareTo(Address o) {
		return this.addId-o.getAddId();
	}
}
