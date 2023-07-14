package com.example.minStudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MinStudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MinStudyApplication.class, args);
	}

}
