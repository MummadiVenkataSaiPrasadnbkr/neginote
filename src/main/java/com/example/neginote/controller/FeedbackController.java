package com.example.neginote.controller;

import java.io.IOException;
import java.nio.file.FileStore;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.neginote.dto.PersonDTO;
import com.example.neginote.dto.PersonDTO2;
import com.example.neginote.dto.StudentFeedBackDAO;
import com.example.neginote.entities.Feedback;
import com.example.neginote.service.FeedbackService;
import com.example.neginote.service.FileService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	private FeedbackService service;
	
	
	@Autowired
	private FileService service1;
	
	@PostMapping("/save")
	public String save(@RequestParam("content") String content,
			@RequestParam("type")  String type,
			@RequestParam("givenBy") String givenBy,
			@RequestParam("givenTo") String givenTo,
			@RequestParam("visibility") String visibility,
			
			@RequestParam(value= "audiopath", required = false) MultipartFile audiopath,
			@RequestParam(value= "videopath", required = false) MultipartFile videoPath,
			@RequestParam(value= "imagepath", required = false) MultipartFile imagePath) throws IOException{
		
		System.out.print(type);
		System.out.print(givenBy);
		System.out.print(givenTo);
		System.out.print(visibility);
		
		return service1.saveFeedback(content, type, givenBy, givenTo, visibility, audiopath, videoPath, imagePath);
		
	}
	
	@PostMapping("/get/{id}")
	public Feedback get(@PathVariable Integer id) {
		return service.get(id);
	}
	
	@GetMapping("/get/messages/{stud}")
	public Iterable<StudentFeedBackDAO> getMessages(@PathVariable String  stud){
		return service.getStudentFeedBack(stud);
	}
	
	@PostMapping("/get/message")
	public Iterable<PersonDTO> getMessages(@RequestBody PersonDTO2 obj){
		System.out.println(obj.getFromId());
		return service.getPersonFeedBack(obj.getLevel(), obj.getFromId(), obj.getToId());
	}
	
	@GetMapping("/getFile")
	public ResponseEntity<Object> getFile(@RequestParam("path") String  path) throws Exception{
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-disposition", "inline;filename=" + "uploads/"+path);

		 return ResponseEntity.ok().headers(headers).body(service1.get(path));
	}

}
