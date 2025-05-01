package com.example.neginote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.neginote.entities.Person;
import com.example.neginote.entities.Student;
import com.example.neginote.service.PersonService;
import com.example.neginote.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@PostMapping("/save")
	public String save(@RequestBody Student person) {
		return service.save(person);
	}
	
	@GetMapping("/get/{id}")
	public Student get(@PathVariable String id) {
		return service.get(id);
	}

}
