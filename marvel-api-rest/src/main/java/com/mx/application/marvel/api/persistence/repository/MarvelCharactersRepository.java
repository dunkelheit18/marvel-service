package com.mx.application.marvel.api.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.application.marvel.api.persistence.entity.Characters;

/**
 * @author jahernandezg
 */
public interface MarvelCharactersRepository extends JpaRepository<Characters, Integer>{

	@Query(value = "     SELECT CO.ID_COMICS,\n"
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
			+ "      WHERE CO.ID_CHARACTERER = :idCharacters", nativeQuery = true)
	public List<Object> getAllCharactersId(@Param("idCharacters") Integer idCharacters);
}
