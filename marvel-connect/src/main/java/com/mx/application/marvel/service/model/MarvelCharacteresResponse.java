package com.mx.application.marvel.service.model;

import java.io.Serializable;

/**
 * @author jahernandezg 
 */
public class MarvelCharacteresResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean success;
	private MarvelCharacters marvelCharacters;
	
	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the marvelCharacters
	 */
	public MarvelCharacters getMarvelCharacters() {
		return marvelCharacters;
	}
	/**
	 * @param marvelCharacters the marvelCharacters to set
	 */
	public void setMarvelCharacters(MarvelCharacters marvelCharacters) {
		this.marvelCharacters = marvelCharacters;
	}
}
