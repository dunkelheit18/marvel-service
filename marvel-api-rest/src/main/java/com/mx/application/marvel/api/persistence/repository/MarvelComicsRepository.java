package com.mx.application.marvel.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.application.marvel.api.persistence.entity.Comics;

/**
 * @author jahernandezg
 */
public interface MarvelComicsRepository extends JpaRepository<Comics, Integer>{

}
