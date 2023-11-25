package com.mx.application.marvel.api.business.service;

import java.util.List;

import com.mx.application.marvel.api.persistence.entity.Bitacora;

/**
 * @author jahernandezg
 */
public interface MarvelBitacoraService {

	public List<Bitacora> bitacoraLoad();
}
