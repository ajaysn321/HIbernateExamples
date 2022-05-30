package com.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "User21May")
public class UserOneToOne {

	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	//@SequenceGenerator(name = "mySequence")
	private int id;
	
	@Column(name= "userName")
	private String name;
	

	@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="addId")
	private Address address;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "UserOneToOne [id=" + id + ", name=" + name + ",\n\t\t address=" + address + "]";
	}

}
