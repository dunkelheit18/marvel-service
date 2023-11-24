
package com.mx.application.marvel.api.persistence.constants;

/**
 * @author jahernandezg
 */
public class MarvelQuerys {

	public static final String ALL_CHARACTERS = "     SELECT CO.ID_COMICS,\n"
			+ "     	    EV.ID_EVENTS,\n"
			+ "     	    SE.ID_SERIES,\n"
			+ "     	    ST.ID_STORIES\n"
			+ "       FROM COMICS CO \n"
			+ " INNER JOIN EVENTS EV\n"
			+ "         ON EV.ID_CHARACTERER = CO.ID_CHARACTERER\n"
			+ " INNER JOIN SERIES SE\n"
			+ "         ON SE.ID_CHARACTERER = EV.ID_CHARACTERER\n"
			+ " INNER JOIN STORIES ST\n"
			+ "         ON ST.ID_CHARACTERER = ST.ID_CHARACTERER\n"
			+ "      WHERE CO.ID_CHARACTERER = :idCharacters";
	
	
	public static final String ALL_COMICS = "SELECT DISTINCT RESOURCE_COMICS,  "
			+ "ID_COMICS, ID_CHARACTERER, NAME_COMICS "
			+ "FROM COMICS WHERE ID_CHARACTERER = :idCharacter";
	
	public static final String ALL_EVENTS = "SELECT DISTINCT RESOURCE_EVENTS,"
			+ " ID_EVENTS, ID_CHARACTERER, NAME_EVENTS "
			+ "FROM EVENTS WHERE ID_CHARACTERER = :idCharacter";
	
	public static final String ALL_SERIES = "SELECT DISTINCT RESOURCE_SERIES, "
			+ "ID_SERIES, ID_CHARACTERER, NAME_SERIES "
			+ "FROM SERIES WHERE ID_CHARACTERER = :idCharacter";
	
	public static final String ALL_STORIES = "SELECT DISTINCT RESOURCE_STORIES, "
			+ "ID_STORIES, ID_CHARACTERER, NAME_STORIES "
			+ "FROM STORIES WHERE ID_CHARACTERER = :idCharacter";
}
