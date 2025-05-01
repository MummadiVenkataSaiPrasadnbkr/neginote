package com.example.neginote.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.neginote.entities.Person;
import com.example.neginote.entities.Student;
import com.example.neginote.repository.PersonRepository;
import com.example.neginote.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository rep;
	
	public String save(Student student) {
		rep.save(student);
		return "object stored successfully";
	}
	
	public Student get(String id) {
		Optional<Student> obj = rep.findById(id);
		return obj.isPresent()?obj.get():null;
	}
}
