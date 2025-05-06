package com.example.neginote.dto;

import java.time.LocalDateTime;

public class PersonDTO extends StudentFeedBackDAO {
	
	
	private String student_id;
	private String student_name;
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public PersonDTO(String personId, String personName, String personType, String feedback, LocalDateTime time, String student_id, String student_name) {
		super(personId, personName, personType, feedback, time);
		this.student_id=student_id;
		this.student_name=student_name;
	}
	
	

}
