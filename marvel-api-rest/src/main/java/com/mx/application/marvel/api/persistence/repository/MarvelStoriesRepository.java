package com.mx.application.marvel.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.application.marvel.api.persistence.entity.Stories;

/**
 * @author jahernandezg
 */
public interface MarvelStoriesRepository extends JpaRepository<Stories, Integer>{

}
