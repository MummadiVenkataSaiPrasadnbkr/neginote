package com.example.neginote.entities;

import jakarta.persistence.Entity;

@Entity
public class Correspondent extends Person{
	
	private String age;
	public Correspondent() {
		this.setType("correspondent");
	}
}
