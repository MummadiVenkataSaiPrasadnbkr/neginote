package com.example.neginote.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.neginote.entities.Person;
import com.example.neginote.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository rep;
	
	public String save(Person person) {
		rep.save(person);
		return "object stored successfully";
	}
	
	public Person get(String id) {
		Optional<Person> obj = rep.findById(id);
		return obj.isPresent()?obj.get():null;
	}

}
