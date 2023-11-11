package com.example.ProjectSpring.application;

import com.example.ProjectSpring.entities.Category;
import com.example.ProjectSpring.entities.Songs;
import com.example.ProjectSpring.repositories.CategoryRepository;
import com.example.ProjectSpring.repositories.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class ProjectSpringApplication implements CommandLineRunner {


    public static void main(String[] args) {
		SpringApplication.run(ProjectSpringApplication.class, args);
	}

    @Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SongsRepository songsRepository;

    @Override
	public void run(String... args) throws Exception{
		Category cat1 = new Category(null, "Mozart");
		Category cat2 = new Category(null, "Paganini");
		Category cat3 = new Category(null, "Vivaldi");

        Songs s1 = new Songs(null, "Eine kleine natchmusik", 1787, cat1);
        Songs s2 = new Songs(null, "La campanella", 1851, cat2);
		Songs s3 = new Songs(null, "Winter", 1830, cat3);
		Songs s4 = new Songs(null, "Rondo alla turca", 1787, cat1);

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);
        categoryRepository.save(cat3);


		cat1.getSongs().addAll(Arrays.asList(s1, s4));
		cat2.getSongs().addAll(Arrays.asList(s2));
		cat3.getSongs().addAll(Arrays.asList(s3));


		songsRepository.save(s1);
		songsRepository.save(s2);
		songsRepository.save(s3);
		songsRepository.save(s4);
	}
}
