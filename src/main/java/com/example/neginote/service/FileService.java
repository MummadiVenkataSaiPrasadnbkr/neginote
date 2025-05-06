package com.example.neginote.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.neginote.entities.Correspondent;
import com.example.neginote.entities.Feedback;
import com.example.neginote.entities.Hod;
import com.example.neginote.entities.Lecturer;
import com.example.neginote.entities.Person;
import com.example.neginote.entities.Principal;
import com.example.neginote.entities.Student;
import com.example.neginote.repository.FeedbackRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FileService {
	
	private static final String STORAGE_DIR = System.getProperty("user.dir") + File.separator + "uploads" + File.separator;
	
	@Autowired
	private FeedbackService rep;
	
	public String saveFeedback(
			String content,
			String type,
			String givenBy,
			String givenTo,
			String visibility,
			
			MultipartFile audiopath,
			MultipartFile videoPath,
			MultipartFile imagePath
			) throws IOException{
		
		String uuidAudio = audiopath!=null?generateUID(audiopath, "audio") : null;
		String uuidVideo=  videoPath!=null?       generateUID(videoPath, "video"): null;
		String uuidImage=  imagePath!=null ? generateUID(imagePath, "image"): null;
		
		Person by=null;
		
		if(type.toLowerCase().equals("lecturer") ) {
			by = new Lecturer();
		}
		else if(type.toLowerCase().equals("hod")) {
			by = new Hod();
		}
		else if(type.toLowerCase().equals("principal")) {
			by = new Principal();
		}
		else if(type.toLowerCase().equals("correspondent")) {
			by = new Correspondent();
		}
		
		Student s1 = new Student();
		s1.setId(givenTo);
		
		by.setId(givenBy);
		ObjectMapper mapper = new ObjectMapper();
        Set<Integer> visibilityList = mapper.readValue(visibility, new TypeReference<Set<Integer>>() {});
        
        
		Feedback obj1 = new Feedback();
		
		obj1.setAudioPath(uuidAudio);
		obj1.setVideoPath(uuidVideo);
		obj1.setImagePath(uuidImage);
		
		obj1.setVisibility(visibilityList);
		obj1.setFeedback(content);
		obj1.setGivenBy(by);
		obj1.setGivenTo(s1);
		
		System.out.println(type);
		System.out.println(givenBy);
		System.out.println(givenTo);
		System.out.println(visibility);
		
		return rep.save(obj1);
	}
	
	private String generateUID(MultipartFile file, String subFolder) throws IOException{
		
		String fileName = file.getOriginalFilename();
		String ext = fileName.substring(fileName.lastIndexOf('.'));
		String uuidName = UUID.randomUUID()+ext;
		Path filePath = Paths.get(STORAGE_DIR+subFolder+"/"+uuidName);
		Files.createDirectories(filePath.getParent());
		file.transferTo(new File(filePath.toString()));
		
		
		return   subFolder + "/" + uuidName;

		
	}
	
	
	
	public InputStreamResource get(String location) throws IOException{
		
		
		File target = new File(STORAGE_DIR+location);
		FileInputStream obj = new FileInputStream(target);
		InputStreamResource obj1 = new InputStreamResource(obj);
		return obj1;
		
	}

}
