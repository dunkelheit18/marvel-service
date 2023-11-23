package com.mx.application.marvel.api.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mx.application.marvel.api.business.service.MarvelProcessDataService;

/**
 * @author jahernandezg
 */
@SpringBootTest
@EnableJpaRepositories
public class MarvelProcessDataServiceTest {

	@Autowired
	private MarvelProcessDataService marvelProcessDataService;
	
	@Test
	public void executeProcesstest() {
		marvelProcessDataService.saveCharactersData("Thor");
	}
}
