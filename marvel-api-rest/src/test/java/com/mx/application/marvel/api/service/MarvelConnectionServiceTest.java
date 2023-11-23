package com.mx.application.marvel.api.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mx.application.marvel.api.business.service.MarvelConnectionService;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;

/**
 * @author jahernandezg
 */
@SpringBootTest
@EnableJpaRepositories
public class MarvelConnectionServiceTest {

	@Autowired
	private MarvelConnectionService marvelConnectionService;
	
	@Test
	public void getCharacterByNameTest() {
		
		MarvelCharacteresResponse response = marvelConnectionService.findCharactersByName("Thor");
		assertNotNull(response);
		assertTrue(response.getSuccess());
	}
}
