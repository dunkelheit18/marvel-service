package com.mx.application.marvel.api.business.service;

import com.mx.application.marvel.api.application.model.MarvelCharcterResponse;

/**
 * @author jahernandezg
 */
public interface MarvelExtractItemsService {

	public MarvelCharcterResponse getItemsByName(String Name);
	
	public MarvelCharcterResponse getItemsById(Integer idCharacters);
}
