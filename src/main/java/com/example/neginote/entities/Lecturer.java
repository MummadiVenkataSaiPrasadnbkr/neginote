package com.example.neginote.entities;

import jakarta.persistence.Entity;

@Entity
public class Lecturer extends Person {
	
	private Integer salary;
	private String address;
	private String dept;
	public Lecturer() {
		this.setType("lecturer");
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	

}
