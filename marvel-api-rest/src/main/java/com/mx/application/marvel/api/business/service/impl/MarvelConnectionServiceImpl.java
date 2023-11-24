package com.mx.application.marvel.api.business.service.impl;

import org.springframework.stereotype.Service;

import com.mx.application.marvel.api.business.service.MarvelConnectionService;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;
import com.mx.application.marvel.service.MarvelService;
import com.mx.application.marvel.service.model.MarvelCharacteresRequest;

/**
 * @author jahernandezg
 */
@Service
public class MarvelConnectionServiceImpl implements MarvelConnectionService {

	private MarvelService marvelService;
	
	public MarvelConnectionServiceImpl(MarvelService marvelService){
		this.marvelService = marvelService;
	}
	
	
	@Override
	public MarvelCharacteresResponse findCharactersByName(String name) {
		MarvelCharacteresRequest request = new MarvelCharacteresRequest();
		request.setName(name);
		return marvelService.getCharacteres(request);
	}


	@Override
	public MarvelCharacteresResponse findCharactersById(Integer idCharacters) {
		return marvelService.getCharacteresById(idCharacters);
	}
}
