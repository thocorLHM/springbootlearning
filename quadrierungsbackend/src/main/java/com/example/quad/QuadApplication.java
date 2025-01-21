package com.example.quad;

import com.example.quad.entities.Calculation;
import com.example.quad.repository.CalculationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class QuadApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuadApplication.class, args);
	}

	/*
@Bean
	CommandLineRunner commandLineRunner(CalculationRepository repo) {
		return args -> {
			Calculation cal = new Calculation(null, 3, 9, LocalDateTime.now());
			repo.save(cal);
		};
	}

	 */

}
