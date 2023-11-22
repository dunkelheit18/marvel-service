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
import com.mx.application.marvel.service.model.MarvelCharacters;
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
		
		MarvelCharacteresResponse response = new MarvelCharacteresResponse();
		response.setSuccess(false);
		String parameters = CHARACTERES + "&name=" + marvelCharacteresRequest.getName();
		String serviceResponse = marvelClientService.getServiceConnect(parameters);
		
		if(serviceResponse != null && !serviceResponse.isEmpty()) {
		
			ObjectMapper mapper = new ObjectMapper();
			try {
				JsonNode jsonNode = mapper.readTree(serviceResponse);			
				MarvelCharacters characters = this.getCharactersObject(jsonNode);
				response.setSuccess(true);
				response.setMarvelCharacters(characters);
				
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
	
	private MarvelCharacters getCharactersObject(JsonNode json) {
		
		MarvelCharacters character = new MarvelCharacters();
		
		JsonNode node = json.findParent("results");
		JsonNode ident = node.findValue("id");
		JsonNode name = node.findValue("name");
		JsonNode desc = node.findValue("description");
		JsonNode date = node.findValue("modified");

		character.setId(ident.asInt());
		character.setName(name.asText());
		character.setDescription(desc.asText());
		character.setModified(date.asText());
		character.setComics(getComicsObject(json));
		character.setEvents(getEventsObject(json));
		character.setSeries(getSeriesObject(json));
		character.setStories(getStoriesObject(json));
		
		return character;
	}
	
	
	private MarvelStories getStoriesObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelStories stories = new MarvelStories();
		
		JsonNode node = json.findValue("stories");
		JsonNode available = node.findValue("available");
		JsonNode url = node.findValue("collectionURI");
		JsonNode data = node.findParent("items");

		
		objectMap =  this.getMap(data);
	
		stories.setCollectionURI(url.asText());
		stories.setAvailable(available.asInt());
		stories.setItems(objectMap);
		
		return stories;
	}
	
	private MarvelSeries getSeriesObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelSeries series = new MarvelSeries();
		
		JsonNode node = json.findValue("series");
		JsonNode available = node.findValue("available");
		JsonNode url = node.findValue("collectionURI");
		JsonNode data = node.findParent("items");
		
		objectMap =  this.getMap(data);
	
		series.setCollectionURI(url.asText());
		series.setAvailable(available.asInt());
		series.setItems(objectMap);
		
		return series;
	}
	
	private MarvelComics getComicsObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelComics comics = new MarvelComics();
		
		JsonNode node = json.findValue("comics");
		JsonNode available = node.findValue("available");
		JsonNode url = node.findValue("collectionURI");
		JsonNode data = node.findParent("items");
		
		objectMap =  this.getMap(data);
	
		comics.setCollectionURI(url.asText());
		comics.setAvailable(available.asInt());
		comics.setItems(objectMap);
		
		return comics;
	}
	
	private MarvelEvents getEventsObject(JsonNode json) {
		
		Map<String, String> objectMap = new HashMap<>();
		MarvelEvents events = new MarvelEvents();
		
		JsonNode node = json.findValue("events");
		JsonNode available = node.findValue("available");
		JsonNode url = node.findValue("collectionURI");
		JsonNode data = node.findParent("items");
		
		objectMap =  this.getMap(data);
	
		events.setCollectionURI(url.asText());
		events.setAvailable(available.asInt());
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
