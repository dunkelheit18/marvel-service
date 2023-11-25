package com.mx.application.marvel.api.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mx.application.marvel.api.persistence.entity.Bitacora;

/**
 * @author jahernandezg
 */
@Repository
public interface MarvelBitacoraAccessRepository extends JpaRepository<Bitacora, Integer>{

}
