package com.mx.application.marvel.api.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.application.marvel.api.application.model.MarvelCharcterResponse;
import com.mx.application.marvel.api.business.service.MarvelBitacoraService;
import com.mx.application.marvel.api.business.service.MarvelExtractItemsService;
import com.mx.application.marvel.api.business.service.MarvelProcessDataService;
import com.mx.application.marvel.api.persistence.entity.Bitacora;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author jahernandezg
 */
@ApiResponses(value = {@ApiResponse(code = 200, message = "Operacion exitosa."),
					   @ApiResponse(code = 404, message = "Servicio no disponible"),
					   @ApiResponse(code = 500, message = "El personaje no se encuntra")})
@Api(value = "Marvel API", description = "Operacion de extraccion de datos de la API de Marver para almacenarlos en una BD.")
@RequestMapping(path = "marvel/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@RestController
public class MarvelApiController {

	@Autowired
	private MarvelProcessDataService marvelProcessDataService;
	
	@Autowired
	private MarvelBitacoraService marvelBitacoraService;
	
	@Autowired
	private MarvelExtractItemsService marvelExtractItemsService;
	
	
	@ApiOperation(value = "Consulta la API de Marvel mediante el nombre del personaje y lo almacena en la BD.", response = Boolean.class)
	@PostMapping(path = "/characters/extractName/{name}")
	public ResponseEntity<Boolean> extracToMarvelCharactersByName
		(@ApiParam(value = "Nombre del personaje", example = "Hulk", required = true)
		 @PathVariable(name = "name", required = true) String name) {
		
		return marvelProcessDataService.saveCharactersDataByName(name) ? 
				new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) : 
					new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Consulta la API de Marvel mediante el ID del personaje y lo almacena en la BD.", response = Boolean.class)
	@PostMapping(path = "/characters/extractId/{id}")
	public ResponseEntity<Boolean> extracToMarvelCharactersById
		(@ApiParam(value = "Identificador del personaje", example = "1009664",required = true)
		 @PathVariable(name = "id", required = true) Integer id) {
		
		return marvelProcessDataService.saveCharactersDataById(id) ? 
				new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK) : 
					new ResponseEntity<>(Boolean.FALSE, HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Consulta la bitacora de consultas a la API de Marvel.", response = ArrayList.class)
	@GetMapping(path = "/bitacora/loadAccess")
	public ResponseEntity<List<Bitacora>> getBitacora(){
		
		List<Bitacora> bitacoraList = marvelBitacoraService.bitacoraLoad();
		
		return CollectionUtils.isEmpty(bitacoraList) ? 
				new ResponseEntity<>(bitacoraList, HttpStatus.BAD_REQUEST):
					new ResponseEntity<>(bitacoraList, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Busca los items del personaje mediante el nombre.", response = MarvelCharcterResponse.class)
	@GetMapping(path = "/characters/findName")
	public ResponseEntity<MarvelCharcterResponse> getCharactersItemsByName
		(@ApiParam(value = "Nombre del Personaje", example = "Thanos", required = true) 
		 @RequestParam(name = "name", required = true) String name){
		
		MarvelCharcterResponse response = marvelExtractItemsService.getItemsByName(name);
		
		return response != null && response.getSuccess() ? 
				new ResponseEntity<>(response, HttpStatus.OK) :
					new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
	
	@ApiOperation(value = "Busca los items del personaje mediante el identificador.", response = MarvelCharcterResponse.class)
	@GetMapping(path = "/characters/findId")
	public ResponseEntity<MarvelCharcterResponse> getCharactersItemsById
		(@ApiParam(value = "Identificador del personaje a consultar", example = "1009664", required = true)
		 @RequestParam(name = "idCharacters", required = true) Integer idCharacters){
		
		MarvelCharcterResponse response = marvelExtractItemsService.getItemsById(idCharacters);
		
		return response != null && response.getSuccess() ? 
				new ResponseEntity<>(response, HttpStatus.OK) :
					new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}
}
