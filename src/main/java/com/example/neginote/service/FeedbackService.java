package com.example.neginote.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.neginote.entities.Feedback;
import com.example.neginote.repository.FeedbackRepository;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository rep;
	
	
	public String save(Feedback feedback) {
		
		rep.save(feedback);
		return "feedback saved successfully";
		
	}
	
	
	public Feedback get(Integer id) {
		Optional<Feedback> obj = rep.findById(id);
		
		return obj.isPresent()?obj.get():null;
		
	}

}
