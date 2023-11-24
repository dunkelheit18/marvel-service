package com.mx.application.marvel.api.business.service;

import com.mx.application.marvel.service.model.MarvelCharacteresResponse;

/**
 * @author jahernandezg
 */
public interface MarvelConnectionService {

	public MarvelCharacteresResponse findCharactersByName(String name);
	
	public MarvelCharacteresResponse findCharactersById(Integer idCharacters);
}
