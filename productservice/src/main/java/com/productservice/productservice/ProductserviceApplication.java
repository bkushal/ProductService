package com.productservice.productservice;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repositories.CategoryRepository;
import com.productservice.productservice.repositories.ProductRepository;

@SpringBootApplication
public class ProductserviceApplication implements CommandLineRunner {

	private MentorRepository mentorRepository;
	private StudentRepository studentRepository;
	private UserRepository userRepository;
	private CategoryRepository categoryRepository;
	private ProductRepository productRepository;
	
	ProductserviceApplication(@Qualifier("st_mentorrepository") MentorRepository mentorRepository, 
			@Qualifier("st_studentrepository") StudentRepository studentRepository, 
			@Qualifier("st_userrepository") UserRepository userRepository,
			CategoryRepository categoryRepository,
			ProductRepository productRepository){
		this.mentorRepository = mentorRepository;
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProductserviceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//List<Category> categories = this.categoryRepository.findByName("Apple Dewvices");
		//Optional<Category> optionalCategory = this.categoryRepository.findByName("Apple Dewvices");
		//if(optionalCategory.isEmpty()) {
		//	throw new Exception("Category is null");
		//}
//		Category category = categories.get(0);
//		
//		Product product = new Product();
//		product.setTitle("IPhone 15 pro");
//		product.setDesc("Best iphone ever");
//		product.setCategory(category);
//		this.productRepository.save(product);
//		
//		List<Product> products = category.getProducts();
//		for(Product productt : products)
//				System.out.println(productt.getDesc());
	}

//	@Override
//	public void run(String... args) throws Exception {
//		// TODO Auto-generated method stub
//		Mentor mentor = new Mentor();
//		mentor.setName("Kushal");
//		mentor.setEmail("kushal@gmail.com");
//		mentor.setAvgRating(4.8);
//		this.mentorRepository.save(mentor);
//		
//		Student student = new Student();
//		student.setEmail("kush@scaler.com");
//		student.setPsp(5.5);
//		student.setName("Kushal New");
//		this.studentRepository.save(student);
//		
//		User user = new User();
//		user.setEmail("user@gmail.com");
//		user.setName("dummy user");
//		this.userRepository.save(user);
//		
//		List<User> users = userRepository.findAll();
//		for(User userr : users) {
//			System.out.println(userr);
//		}
//		
//	}

}
