package com.mx.application.marvel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.application.marvel.service.MarvelService;
import com.mx.application.marvel.service.model.MarvelCharacteresRequest;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;

/**
 * @author jahernandezg
 */
@Component
public class MarvelConnectRunner implements CommandLineRunner{

	private MarvelService marvelService;
	
	@Override
	public void run(String... args) throws Exception {
		
		MarvelCharacteresRequest request = new MarvelCharacteresRequest();
		request.setName("Thor");
		
		MarvelCharacteresResponse response = marvelService.getCharacteres(request);
		ObjectMapper mapper = new ObjectMapper();
		
		String result = mapper.writeValueAsString(response);	
		System.out.println(result);
	}
}
