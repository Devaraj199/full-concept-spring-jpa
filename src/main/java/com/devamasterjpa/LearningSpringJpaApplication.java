package com.devamasterjpa;

import com.devamasterjpa.models.Author;
import com.devamasterjpa.models.Video;
import com.devamasterjpa.repository.AuthorRepository;
import com.devamasterjpa.repository.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearningSpringJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringJpaApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository,
											   VideoRepository videoRepository){
		return args ->{
//			Author author = new Author();
//			author.setFirstName("Raju");
//			author.setLastName("Pradhan");
//			author.setAge(37);
//			author.setEmail("devaraj@gmail.com");
//			authorRepository.save(author);
			Video video = new Video();
//			video.setLength(32);
//			video.setName("abc");
//			videoRepository.save(video);
		};
	}
}
