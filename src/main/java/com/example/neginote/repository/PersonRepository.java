package com.example.neginote.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.neginote.entities.Person;

public interface PersonRepository extends CrudRepository<Person, String> {

}
