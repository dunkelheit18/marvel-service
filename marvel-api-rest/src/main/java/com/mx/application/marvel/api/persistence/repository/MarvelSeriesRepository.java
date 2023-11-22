package com.mx.application.marvel.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.application.marvel.api.persistence.entity.Series;

/**
 * @author jahernandezg
 */
public interface MarvelSeriesRepository extends JpaRepository<Series, Integer>{

}
