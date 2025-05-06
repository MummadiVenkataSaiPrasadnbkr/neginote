package com.example.neginote.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.neginote.dto.PersonDTO;
import com.example.neginote.dto.StudentFeedBackDAO;
import com.example.neginote.entities.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer>{
				
	
	
	@Query("SELECT new com.example.neginote.dto.StudentFeedBackDAO(f.givenBy.id, f.givenBy.name, f.givenBy.type, f.feedback, f.time) " +
		       "FROM Feedback f WHERE f.givenTo.id = :id AND :role MEMBER OF f.visibility")
		public Iterable<StudentFeedBackDAO> getStudentFeedback(@Param("id") String id, @Param("role") Integer role);
	
	
	@Query("SELECT new com.example.neginote.dto.PersonDTO(" +
		       "f.givenBy.id, f.givenBy.name, f.givenBy.type, " +
		       "f.feedback, f.time, f.givenTo.id, f.givenTo.name) " +
		       "FROM Feedback f JOIN f.visibility v " +
		       "WHERE v = :vis " +
		       "AND (:fromId IS NULL OR f.givenBy.id = :fromId) " +
		       "AND (:toId IS NULL OR f.givenTo.id = :toId)")
	public Iterable<PersonDTO> getPersonFeedback(@Param("vis") Integer vis, @Param("fromId") String fromId, @Param("toId") String toId);

}
