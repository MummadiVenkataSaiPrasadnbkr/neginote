package com.example.neginote.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Person givenBy;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Student givenTo;
	
	private String feedback;
	
	private LocalDateTime time;
	
	private Set<String> visibility = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Person getGivenBy() {
		return givenBy;
	}

	public void setGivenBy(Person givenBy) {
		this.givenBy = givenBy;
	}

	public Student getGivenTo() {
		return givenTo;
	}

	public void setGivenTo(Student givenTo) {
		this.givenTo = givenTo;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Set<String> getVisibility() {
		return visibility;
	}

	public void setVisibility(Set<String> visibility) {
		this.visibility = visibility;
	}
	
	

}
