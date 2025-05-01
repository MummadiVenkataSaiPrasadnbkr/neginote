package com.example.neginote.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.neginote.entities.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

}
