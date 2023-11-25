package com.mx.application.marvel.api.business.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mx.application.marvel.api.business.service.MarvelBitacoraService;
import com.mx.application.marvel.api.persistence.entity.Bitacora;
import com.mx.application.marvel.api.persistence.repository.MarvelBitacoraAccessRepository;

/**
 * @author jahernandezg
 */
@Service
public class MarvelBitacoraServiceImpl implements MarvelBitacoraService {

	private MarvelBitacoraAccessRepository marvelBitacoraAccessRepository;
	
	public MarvelBitacoraServiceImpl(MarvelBitacoraAccessRepository marvelBitacoraAccessRepository) {
		this.marvelBitacoraAccessRepository = marvelBitacoraAccessRepository;
	}
	
	@Override
	public List<Bitacora> bitacoraLoad() {
		
		return marvelBitacoraAccessRepository.findAll();
	}

}
