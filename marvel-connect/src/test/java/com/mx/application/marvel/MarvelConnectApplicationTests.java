package com.mx.application.marvel;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.application.marvel.service.MarvelService;
import com.mx.application.marvel.service.model.MarvelCharacteresRequest;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;

@SpringBootTest
class MarvelConnectApplicationTests {

	@Autowired
	private MarvelService marvelService;
	
	@Test
	void getCharactereByName() throws JsonProcessingException {
	
		MarvelCharacteresRequest request = new MarvelCharacteresRequest();
		request.setName("Thor");
		
		MarvelCharacteresResponse response = marvelService.getCharacteres(request);
		assertNotNull(response);
		assertTrue(response.getSuccess());
		ObjectMapper mapper = new ObjectMapper();
		
		String result = mapper.writeValueAsString(response);
		assertNotNull(result);
		System.out.println(result);
	}

}
