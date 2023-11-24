package com.mx.application.marvel.api.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.application.marvel.api.business.service.MarvelConnectionService;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;
import com.mx.application.marvel.api.business.service.MarvelExctractService;

/**
 * @author jahernandezg
 */
@Service
public class MarvelExctractServiceImpl implements MarvelExctractService {

	@Autowired
	private MarvelConnectionService marvelConnectionService;
	
	public MarvelCharacteresResponse extractDataByName(String name) {
		 return marvelConnectionService.findCharactersByName(name);
	}

	@Override
	public MarvelCharacteresResponse extractDataById(Integer idCharacters) {
		return marvelConnectionService.findCharactersById(idCharacters);
	}
}
