package com.example.neginote.entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.EXISTING_PROPERTY,
	    property = "type"
	)
	@JsonSubTypes({
	    @JsonSubTypes.Type(value = Student.class, name = "student"),
	    @JsonSubTypes.Type(value = Lecturer.class, name = "lecturer"),
	    @JsonSubTypes.Type(value= Hod.class , name="hod"),
	    @JsonSubTypes.Type(value=Principal.class, name="principal"),
	    @JsonSubTypes.Type(value=Correspondent.class , name="correspondent")
	})
public abstract class Person {
	
	@Id
	private String id;
	private String name;
	private String type;
	public Person() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Person(String id, String name, String type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	
	
	

}
