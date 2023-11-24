package com.mx.application.marvel.api.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.mx.application.marvel.api.business.service.MarvelProcessDataService;

/**
 * @author jahernandezg
 */
@RequestMapping(path = "marvel/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class MarvelApiController {

	@Autowired
	private MarvelProcessDataService marvelProcessDataService;
	
	@PostMapping(path = "/characters/extractName/{name}")
	public ResponseEntity<Boolean> extracToMarvelCharactersByName
		(@PathVariable(name = "name", required = true) String name) {
		
		return new ResponseEntity<>(marvelProcessDataService.saveCharactersDataByName(name), HttpStatus.OK);
	}
	
	@PostMapping(path = "/characters/extractId/{id}")
	public ResponseEntity<Boolean> extracToMarvelCharactersById
		(@PathVariable(name = "id", required = true) Integer id) {
		
		return new ResponseEntity<>(marvelProcessDataService.saveCharactersDataById(id), HttpStatus.OK);
	}
}
