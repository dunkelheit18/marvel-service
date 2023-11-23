package com.mx.application.marvel.utils.endpoint;

/**
 * @author jahernandezg
 */
public class MarvelEndpoint {

	private MarvelEndpoint() {}
	
	public static final String CHARACTERES = "http://gateway.marvel.com/v1/public/characters?"
			+ "ts=1&apikey=5365d50e0ed423f38197671843b5d60a&hash=9a5059a3bae61e6b564ff7b1e467b56c";
	
	public static final String CHARACTERS_ID = "ttp://gateway.marvel.com/v1/public/characters/{id}?"
			+ "ts=1&apikey=5365d50e0ed423f38197671843b5d60a&hash=9a5059a3bae61e6b564ff7b1e467b56c";
}
