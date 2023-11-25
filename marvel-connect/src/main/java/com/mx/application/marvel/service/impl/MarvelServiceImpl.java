package com.mx.application.marvel.service.impl;

import static com.mx.application.marvel.utils.business.MarvelUtils.getComicsItems;
import static com.mx.application.marvel.utils.business.MarvelUtils.getEventsItems;
import static com.mx.application.marvel.utils.business.MarvelUtils.getSeriesItems;
import static com.mx.application.marvel.utils.business.MarvelUtils.getStoriesItems;
import static com.mx.application.marvel.utils.business.MarvelUtils.getCharacterData;
import static com.mx.application.marvel.utils.endpoint.MarvelEndpoint.CHARACTERES;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.application.marvel.service.MarvelClientService;
import com.mx.application.marvel.service.MarvelService;
import com.mx.application.marvel.service.model.MarvelCharacters;
import com.mx.application.marvel.service.model.MarvelCharacteresRequest;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;

/**
 * @author jahernandezg
 */
@Service
public class MarvelServiceImpl implements MarvelService {

	@Autowired
	private MarvelClientService marvelClientService;
	
	@Override
	public MarvelCharacteresResponse getCharacteres
		(MarvelCharacteresRequest marvelCharacteresRequest) {
		
		MarvelCharacteresResponse response = new MarvelCharacteresResponse();
		response.setSuccess(false);
		String parameters = CHARACTERES + "&name=" + marvelCharacteresRequest.getName();
		String serviceResponse = marvelClientService.getServiceConnect(parameters);
		
		if(serviceResponse != null && !serviceResponse.isEmpty()) {
		
			ObjectMapper mapper = new ObjectMapper();
			try {
				MarvelCharacters obj = mapper.readValue(serviceResponse, MarvelCharacters.class);
				if(obj != null) {
					String[] charactersData =  getCharacterData(obj);
					
					response.setId(charactersData[0]!= null && charactersData[0] != ""? Integer.parseInt(charactersData[0]) : 0);
					response.setName(charactersData[1]);
					response.setDescription(charactersData[2]);
					response.setModified(charactersData[3]);
					response.setComics(getComicsItems(obj));
					response.setEvents(getEventsItems(obj));
					response.setSeries(getSeriesItems(obj));
					response.setStories(getStoriesItems(obj));
					response.setSuccess(true);
					response.setMarvelCharacters(obj);
				}
				else {
					response.setSuccess(false);
				}
			} catch (JsonMappingException e) {
				response.setSuccess(false);
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				response.setSuccess(false);
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	@Override
	public MarvelCharacteresResponse getCharacteresById(Integer idCharacters) {
		
		MarvelCharacteresResponse response = new MarvelCharacteresResponse();
		response.setSuccess(false);
		String parameters = CHARACTERES;
		parameters = parameters.replace("{id}", idCharacters.toString());
		String serviceResponse = marvelClientService.getServiceConnect(parameters);
		
		if(serviceResponse != null && !serviceResponse.isEmpty()) {
		
			ObjectMapper mapper = new ObjectMapper();
			
			try {			
				MarvelCharacters obj = mapper.readValue(serviceResponse, MarvelCharacters.class);
				
				if(obj != null) {
					String[] charactersData =  getCharacterData(obj);
					
					response.setId(charactersData[0]!= null && charactersData[0] != ""? Integer.parseInt(charactersData[0]) : 0);
					response.setName(charactersData[1]);
					response.setDescription(charactersData[2]);
					response.setModified(charactersData[3]);
					response.setComics(getComicsItems(obj));
					response.setEvents(getEventsItems(obj));
					response.setSeries(getSeriesItems(obj));
					response.setStories(getStoriesItems(obj));
					response.setSuccess(true);
					response.setMarvelCharacters(obj);
				}
				else {
					response.setSuccess(false);
				}
			} catch (JsonMappingException e) {
				response.setSuccess(false);
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				response.setSuccess(false);
				e.printStackTrace();
			}
		}
		
		return response;
	}
}
