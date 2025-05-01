package com.example.neginote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.neginote.entities.Feedback;
import com.example.neginote.service.FeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService service;
	
	@PostMapping("/save")
	public String save(@RequestBody Feedback feedback) {
		return service.save(feedback);
	}
	
	@PostMapping("/get/{id}")
	public Feedback get(@PathVariable Integer id) {
		return service.get(id);
	}

}
