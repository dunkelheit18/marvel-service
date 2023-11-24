package com.mx.application.marvel.api.business.service;

/**
 * @author jahernandezg
 */
public interface MarvelProcessDataService {

	public boolean saveCharactersDataByName(String name);
	
	public boolean saveCharactersDataById(Integer id);
}
