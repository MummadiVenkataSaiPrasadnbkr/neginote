package com.example.neginote.dto;

import java.time.LocalDateTime;

public class StudentFeedBackDAO {
	
	private String personId;
	private String personName;
	private String personType;
	private String feedback;
	private LocalDateTime time;
	
	public StudentFeedBackDAO(String personId, String personName, String personType, String feedback,
			LocalDateTime time) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personType = personType;
		this.feedback = feedback;
		this.time = time;
	}
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonType() {
		return personType;
	}
	public void setPersonType(String personType) {
		this.personType = personType;
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
	
	

}
