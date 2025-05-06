package com.example.neginote.entities;

import jakarta.persistence.Entity;

@Entity
public class Correspondent extends Person{
	
	private Integer age;
	public Correspondent() {
		this.setType("correspondent");
	}
	public Correspondent(String id, String name, String type, Integer age) {
		super(id, name, type);
		this.age=age;
	}
	
	
	
}
