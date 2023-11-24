package com.mx.application.marvel.api.persistence.repository;

import static com.mx.application.marvel.api.persistence.constants.MarvelQuerys.ALL_CHARACTERS;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mx.application.marvel.api.persistence.entity.Characters;

/**
 * @author jahernandezg
 */
public interface MarvelCharactersRepository extends JpaRepository<Characters, Integer>{

	@Query(value = ALL_CHARACTERS, nativeQuery = true)
	public List<Object> getAllCharactersId(@Param("idCharacters") Integer idCharacters);
}
