package com.mx.application.marvel.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.application.marvel.api.persistence.entity.Events;

/**
 * @author jahernandezg
 */
public interface MarvelEventsRepository extends JpaRepository<Events, Integer>{

}
