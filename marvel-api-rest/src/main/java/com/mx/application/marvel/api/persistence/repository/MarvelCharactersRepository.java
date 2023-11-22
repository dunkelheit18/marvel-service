package com.mx.application.marvel.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.application.marvel.api.persistence.entity.Characters;

/**
 * @author jahernandezg
 */
public interface MarvelCharactersRepository extends JpaRepository<Characters, Integer>{

}
