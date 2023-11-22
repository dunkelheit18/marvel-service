package com.mx.application.marvel.service.impl;

import static com.mx.application.marvel.utils.endpoint.MarvelEndpoint.CHARACTERES;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mx.application.marvel.service.MarvelClientService;
import com.mx.application.marvel.service.MarvelService;
import com.mx.application.marvel.service.model.MarvelCharacteresRequest;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;
import com.mx.application.marvel.service.model.MarvelComics;
import com.mx.application.marvel.service.model.MarvelEvents;
import com.mx.application.marvel.service.model.MarvelSeries;
import com.mx.application.marvel.service.model.MarvelStories;

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
		
		MarvelCharacteresResponse response = null;
		
		String serviceResponse = marvelClientService.getServiceConnect(CHARACTERES);
		
		if(serviceResponse != null && !serviceResponse.isEmpty()) {
		
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper.readTree(serviceResponse);
				MarvelComics comics   = getComicsObject(jsonNode);
				MarvelEvents events   = getEventsObject(jsonNode);
				MarvelSeries series   = getSeriesObject(jsonNode);
				MarvelStories stories = getStoriesObject(jsonNode);
				
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}
		
		return response;
	}
	
	private MarvelStories getStoriesObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelStories stories = new MarvelStories();
		
		JsonNode node = json.get("stories");
		JsonNode available = node.get("available");
		JsonNode url = node.get("collectionURI");
		JsonNode data = node.get("items");
		String availa = available.asText();
		
		objectMap =  this.getMap(data);
		
		Integer avaFormat = Integer.parseInt(availa);
	
		stories.setCollectionURI(url.asText());
		stories.setAvailable(avaFormat);
		stories.setItems(objectMap);
		
		return stories;
	}
	
	private MarvelSeries getSeriesObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelSeries series = new MarvelSeries();
		
		JsonNode node = json.get("series");
		JsonNode available = node.get("available");
		JsonNode url = node.get("collectionURI");
		JsonNode data = node.get("items");
		String availa = available.asText();
		
		objectMap =  this.getMap(data);
		
		Integer avaFormat = Integer.parseInt(availa);
	
		series.setCollectionURI(url.asText());
		series.setAvailable(avaFormat);
		series.setItems(objectMap);
		
		return series;
	}
	
	private MarvelComics getComicsObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelComics comics = new MarvelComics();
		
		JsonNode node = json.get("comics");
		JsonNode available = node.get("available");
		JsonNode url = node.get("collectionURI");
		JsonNode data = node.get("items");
		String availa = available.asText();
		
		objectMap =  this.getMap(data);
		
		Integer avaFormat = Integer.parseInt(availa);
	
		comics.setCollectionURI(url.asText());
		comics.setAvailable(avaFormat);
		comics.setItems(objectMap);
		
		return comics;
	}
	
	private MarvelEvents getEventsObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelEvents events = new MarvelEvents();
		
		JsonNode node = json.get("events");
		JsonNode available = node.get("available");
		JsonNode url = node.get("collectionURI");
		JsonNode data = node.get("items");
		String availa = available.asText();
		
		objectMap =  this.getMap(data);
		
		Integer avaFormat = Integer.parseInt(availa);
	
		events.setCollectionURI(url.asText());
		events.setAvailable(avaFormat);
		events.setItems(objectMap);
		
		return events;
	}
	
	private Map<String, String>getMap(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		Iterator<Map.Entry<String, JsonNode>> campos = json.fields();
		
		while (campos.hasNext()) {
			
			Map.Entry<String, JsonNode> campo = campos.next();
			
			String key     = campo.getKey();
			JsonNode value = campo.getValue();
			
			objectMap.put(key, value.asText());
			
		}
		
		return objectMap;
	}
}
