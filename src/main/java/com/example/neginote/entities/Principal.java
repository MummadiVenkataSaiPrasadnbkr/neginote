package com.example.neginote.entities;

import jakarta.persistence.Entity;

@Entity
public class Principal extends Person{
	
	private Integer salary;
	private String address;
	public Principal() {
		this.setType("principal");
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Principal(String id, String name, String type,Integer salary, String address) {
		super(id, name, type);
		this.salary = salary;
		this.address = address;
	}

}
