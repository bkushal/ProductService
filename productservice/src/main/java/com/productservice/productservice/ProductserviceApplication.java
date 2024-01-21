package com.productservice.productservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.productservice.productservice.inheritancerelation.mappedsuperclass.Student;
import com.productservice.productservice.inheritancerelation.singletable.Mentor;
import com.productservice.productservice.inheritancerelation.singletable.MentorRepository;
import com.productservice.productservice.inheritancerelation.singletable.Student;
import com.productservice.productservice.inheritancerelation.singletable.StudentRepository;
import com.productservice.productservice.inheritancerelation.singletable.User;
import com.productservice.productservice.inheritancerelation.singletable.UserRepository;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;
	private UserRepository userRepository;
	
	ProductserviceApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository, 
			@Qualifier("st_studentrepository") StudentRepository studentRepository, 
			@Qualifier("st_userrepository") UserRepository userRepository){
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Mentor mentor = new Mentor();
		mentor.setName("Kushal");
		mentor.setEmail("kushal@gmail.com");
		mentor.setAvgRating(4.8);
		this.mentorRepository.save(mentor);
		
		Student student = new Student();
		student.setEmail("kush@scaler.com");
		student.setPsp(5.5);
		student.setName("Kushal New");
		this.studentRepository.save(student);
		
		User user = new User();
		user.setEmail("user@gmail.com");
		user.setName("dummy user");
		this.userRepository.save(user);
		
		List<User> users = userRepository.findAll();
		for(User userr : users) {
			System.out.println(userr);
		}
		
	}

}
