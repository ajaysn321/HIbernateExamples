package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Person {

	@Id
	private int pid;
	
	private String pname;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "sim_Person",joinColumns = @JoinColumn(name="person_id"),inverseJoinColumns = @JoinColumn(name="sim_id"))
	private Set<Simcard> simcards = new HashSet<Simcard>();

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set<Simcard> getSimcards() {
		return simcards;
	}

	public void setSimcards(Set<Simcard> simcards) {
		this.simcards = simcards;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", simcards=" + simcards + "]";
	} 
	
	
}
