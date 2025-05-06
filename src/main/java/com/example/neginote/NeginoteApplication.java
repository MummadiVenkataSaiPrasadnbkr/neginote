package com.example.neginote;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.neginote.controller.FeedbackController;
import com.example.neginote.controller.PersonController;
import com.example.neginote.controller.StudentController;
import com.example.neginote.entities.Correspondent;
import com.example.neginote.entities.Feedback;
import com.example.neginote.entities.Hod;
import com.example.neginote.entities.Lecturer;
import com.example.neginote.entities.Person;
import com.example.neginote.entities.Student;
import com.example.neginote.service.FeedbackService;

@SpringBootApplication
public class NeginoteApplication implements CommandLineRunner{

	
	@Autowired
	private StudentController stud;
	
	@Autowired
	private PersonController per;
	
	@Autowired
	FeedbackService feed;
	
	public static void main(String[] args) {
		SpringApplication.run(NeginoteApplication.class, args);
	}
	
	public void run(String... args) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

		Student s1 = new Student();
        s1.setId("S001");
        s1.setName("Alice");
        s1.setAge(20);
        s1.setClassName("3rd Year");
        s1.setSection("A");
        s1.setType("Regular");
        s1.setDept("CSE");
        stud.save(s1);

        Student s2 = new Student();
        s2.setId("S002");
        s2.setName("Bob");
        s2.setAge(21);
        s2.setClassName("3rd Year");
        s2.setSection("B");
        s2.setType("Regular");
        s2.setDept("ECE");
        stud.save(s2);

        Student s3 = new Student();
        s3.setId("S003");
        s3.setName("Charlie");
        s3.setAge(19);
        s3.setClassName("2nd Year");
        s3.setSection("A");
        s3.setType("Lateral");
        s3.setDept("EEE");
        stud.save(s3);
        
        
     // ----- Create People -----

        com.example.neginote.entities.Principal principal1 = new com.example.neginote.entities.Principal("P001", "Alice", "principal", 120000, "Principal Quarters");
        per.save(principal1);

        Hod hod1 = new Hod("H001", "Bob", "hod", 100000, "HOD Block", "CSE", 45);
        per.save(hod1);
        Lecturer lecturer1 = new Lecturer("L001", "Charlie", "lecturer", 80000, "Staff Quarters", "CSE");
        per.save(lecturer1);
        Lecturer lecturer2 = new Lecturer("L002", "Nina", "lecturer", 82000, "Block B", "IT");
        per.save(lecturer2);
//        Student student1 = new Student("S001", "Diana", "student", 20, "III B.Tech", "A", "CSE");
//        Student student2 = new Student("S002", "Ravi", "student", 21, "IV B.Tech", "B", "IT");

        Correspondent correspondent1 = new Correspondent("C001", "Evan", "correspondent", 55);
        per.save(correspondent1);
        
        
        
        feed.save(new Feedback(principal1, s1, "Excellent performance.", LocalDateTime.parse("2025-05-01 10:30", formatter), Set.of(1, 2)));// visible to principal and hod
        feed.save(new Feedback(hod1, s1, "Good participation in class.", LocalDateTime.parse("2025-05-01 11:00", formatter), Set.of(2, 3))); // hod, lecturer
        feed.save(new Feedback(lecturer1, s2, "Needs improvement in assignments.", LocalDateTime.parse("2025-05-01 11:30", formatter), Set.of(2, 3))); // hod, lecturer
        feed.save(new Feedback(lecturer2, s2, "Punctual and attentive.", LocalDateTime.parse("2025-05-01 12:00", formatter), Set.of(1, 2, 4))); // principal, hod, nina
        feed.save(new Feedback(hod1, s3, "Strong presentation skills.", LocalDateTime.parse("2025-05-01 13:00", formatter), Set.of(1, 5))); // principal and correspondent
        feed.save(new Feedback(correspondent1, s3, "Keep up the hard work.", LocalDateTime.parse("2025-05-01 14:00", formatter), Set.of(2))); // hod only
        

        
	}

}
