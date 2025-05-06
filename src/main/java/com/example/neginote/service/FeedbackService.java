package com.example.neginote.service;

import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.neginote.dto.PersonDTO;
import com.example.neginote.dto.StudentFeedBackDAO;
import com.example.neginote.entities.Feedback;
import com.example.neginote.repository.FeedbackRepository;
import com.example.neginote.utils.RolesHeirarchy;

@Service
public class FeedbackService {
	
	@Autowired
	private FeedbackRepository rep;
	
	
	public String save(Feedback feedback) {
		
		Integer level = RolesHeirarchy.ROLE_HIERARCHY.get(feedback.getGivenBy().getType());
		HashSet<Integer> a = new HashSet<Integer>(feedback.getVisibility());
		for(int i = 0; i <= level; i++) {
			a.add(i);
		}
		feedback.setVisibility(a);
	
		rep.save(feedback);
		return "feedback saved successfully";
		
	}
	
	
	public Feedback get(Integer id) {
		Optional<Feedback> obj = rep.findById(id);
		
		return obj.isPresent()?obj.get():null;
		
	}
	
	
	public Iterable<StudentFeedBackDAO> getStudentFeedBack(String id){
		
		return rep.getStudentFeedback(id, 4);
		
	}
	
	public Iterable<PersonDTO> getPersonFeedBack(String type, String fromId, String toId){
		
		Integer level = RolesHeirarchy.ROLE_HIERARCHY.get(type);
		
		
		return rep.getPersonFeedback(level,fromId,toId);
		
	}
	
	

}
