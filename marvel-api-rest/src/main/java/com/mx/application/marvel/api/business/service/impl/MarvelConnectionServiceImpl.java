package com.mx.application.marvel.api.business.service.impl;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.mx.application.marvel.api.business.service.MarvelConnectionService;
import com.mx.application.marvel.api.persistence.entity.Bitacora;
import com.mx.application.marvel.api.persistence.repository.MarvelBitacoraAccessRepository;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;
import com.mx.application.marvel.service.MarvelService;
import com.mx.application.marvel.service.model.MarvelCharacteresRequest;

/**
 * @author jahernandezg
 */
@Service
public class MarvelConnectionServiceImpl implements MarvelConnectionService {

	private MarvelService marvelService;
	
	private MarvelBitacoraAccessRepository marvelBitacoraAccessRepository;
	
	public MarvelConnectionServiceImpl(MarvelService marvelService,
			MarvelBitacoraAccessRepository marvelBitacoraAccessRepository){
		this.marvelService = marvelService;
		this.marvelBitacoraAccessRepository = marvelBitacoraAccessRepository;
	}
	
	
	@Override
	public MarvelCharacteresResponse findCharactersByName(String name) {
		MarvelCharacteresRequest request = new MarvelCharacteresRequest();
		request.setName(name);
		
		MarvelCharacteresResponse response = marvelService.getCharacteres(request); 
		marvelBitacoraAccessRepository.save(Bitacora.builder()
				.idCharacters(response.getId())
				.dateAcces(new Date())
				.build());
		
		return response;
	}


	@Override
	public MarvelCharacteresResponse findCharactersById(Integer idCharacters) {
		
		MarvelCharacteresResponse response = marvelService.getCharacteresById(idCharacters);
		marvelBitacoraAccessRepository.save(Bitacora.builder()
				.idCharacters(response.getId())
				.dateAcces(new Date())
				.build());
		
		return response;
	}
}
