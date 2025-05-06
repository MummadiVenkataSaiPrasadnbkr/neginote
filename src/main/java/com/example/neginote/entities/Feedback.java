package com.example.neginote.entities;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Feedback {
	
	
	public Feedback() {
		this.time=LocalDateTime.now();
	}
	
	
	public Feedback(Person givenBy, Student givenTo, String feedback, LocalDateTime time,
			Set<Integer> visibility) {
		super();
		
		this.givenBy = givenBy;
		this.givenTo = givenTo;
		this.feedback = feedback;
		this.time = time;
		this.visibility = visibility;
	}


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
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(
			name="feedback_visibility",
			joinColumns = @JoinColumn(name = "id")
			
			)
	
	private Set<Integer> visibility = new HashSet<>();
	
	private String audioPath;
	private String videoPath;
	private String imagePath;
	

	public String getAudioPath() {
		return audioPath;
	}


	public void setAudioPath(String audioPath) {
		this.audioPath = audioPath;
	}


	public String getVideoPath() {
		return videoPath;
	}


	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public void setVisibility(Set<Integer> visibility) {
		this.visibility = visibility;
	}


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

	public Set<Integer> getVisibility() {
		return visibility;
	}
	
	

}
