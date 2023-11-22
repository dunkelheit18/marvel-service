package com.mx.application.marvel.service;

import com.mx.application.marvel.service.model.MarvelCharacteresRequest;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;

/**
 * @author jahernandezg
 */
public interface MarvelService {

	/**
	 * @param marvelCharacteresRequest
	 * @return marvelCharacteresRequest
	 */
	public MarvelCharacteresResponse getCharacteres(MarvelCharacteresRequest marvelCharacteresRequest);
}
