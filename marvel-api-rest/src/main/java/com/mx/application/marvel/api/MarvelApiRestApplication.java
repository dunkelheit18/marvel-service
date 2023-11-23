package com.mx.application.marvel.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.mx.application.marvel.api", "com.mx.application.marvel"})
@SpringBootApplication
public class MarvelApiRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarvelApiRestApplication.class, args);
	}

}
