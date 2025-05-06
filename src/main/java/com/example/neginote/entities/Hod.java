package com.example.neginote.entities;

import jakarta.persistence.Entity;

@Entity
public class Hod extends Person{
	
	
	private Integer salary;
	private String address;
	private String dept;
	private Integer age;
	public Hod() {
		this.setType("hod");
	}
	public Hod(String id, String name, String type,Integer salary, String address, String dept, Integer age) {
		super(id, name, type);
		this.salary = salary;
		this.address = address;
		this.dept = dept;
		this.age = age;
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
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	

}
