package com.library.library;

import com.library.library.Repositories.AuthorRepository;
import com.library.library.Repositories.BookRepository;
import com.library.library.Repositories.CardRepository;
import com.library.library.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.library.library.Model.*;
import java.util.Arrays;


@SpringBootApplication
public class StudentLibraryApplication implements CommandLineRunner {



	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CardRepository cardRepository;


	@Autowired
	AuthorRepository authorRepository;

	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentLibraryApplication.class, args);
	}

	@Override
	public void run(String... args)throws Exception {

		Student student =new Student("abc@gnail.com","Utsab",21,"India");

		Card card=new Card();
		card.setStudent(student);//Mainly providing you with a two ways relationship
		student.setCard(card);

		cardRepository.save(card);
		studentRepository.updateStudentEmail("abc@gnail.com","abc@1234");

		Author author=new Author("Utsab","Utsab@gmail.com",56,"India");
		Book book=new Book("Intro to Physics", Genre.PHYSICS,author);
		author.setBooks_written(Arrays.asList(book));
		authorRepository.save(author);
		cardRepository.findAll().stream().forEach(System.out::println);


		//Saving the parent automatically saves the student


	}
}
