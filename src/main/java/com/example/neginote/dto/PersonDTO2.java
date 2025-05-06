package com.example.neginote.dto;



public class PersonDTO2 {
	
	
	private String level;
	
	private String fromId;
	
	private String toId;

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getFromId() {
		return fromId;
	}

	public void setFromId(String fromId) {
		this.fromId = fromId;
	}

	public String getToId() {
		return toId;
	}

	public void setToId(String toId) {
		this.toId = toId;
	}

	public PersonDTO2(String level, String fromId, String toId) {
		super();
		this.level = level;
		this.fromId = fromId;
		this.toId = toId;
	}
	
	

}
