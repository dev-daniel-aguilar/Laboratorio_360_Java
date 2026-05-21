package com.dinopark.dino_park;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class DinoParkApplication {

	public static void main(String[] args) {
		SpringApplication.run(DinoParkApplication.class, args);
	}

}
