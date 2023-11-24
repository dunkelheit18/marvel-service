package com.mx.application.marvel.api.business.service;

import com.mx.application.marvel.service.model.MarvelCharacteresResponse;

/**
 * @author jahernandezg
 */
public interface MarvelExctractService {

	public MarvelCharacteresResponse extractDataByName(String name);
	
	public MarvelCharacteresResponse extractDataById(Integer idCharacters);
}
