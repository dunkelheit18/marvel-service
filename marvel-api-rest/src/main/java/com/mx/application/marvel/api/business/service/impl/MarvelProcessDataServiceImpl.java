package com.mx.application.marvel.api.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.application.marvel.api.business.service.MarvelExctractService;
import com.mx.application.marvel.api.business.service.MarvelProcessDataService;
import com.mx.application.marvel.api.persistence.entity.Comics;
import com.mx.application.marvel.api.persistence.entity.Events;
import com.mx.application.marvel.api.persistence.repository.MarvelComicsRepository;
import com.mx.application.marvel.api.persistence.repository.MarvelEventsRepository;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;
import com.mx.application.marvel.service.model.MarvelComics;
import com.mx.application.marvel.service.model.MarvelEvents;
import com.mx.application.marvel.service.model.MarvelItems;
import com.mx.application.marvel.service.model.MarvelSeries;
import com.mx.application.marvel.service.model.MarvelStories;

/**
 * @author jahernandezg
 */
@Service
public class MarvelProcessDataServiceImpl implements MarvelProcessDataService{

	@Autowired
	private MarvelExctractService marvelExctractService;
	
	@Autowired
	private MarvelComicsRepository marvelComicsRepository;
	
	@Autowired
	private MarvelEventsRepository marvelEventsRepository;
	
	@Override
	public void saveCharactersData(String name) {
		
		MarvelCharacteresResponse response = marvelExctractService.extractData(name);
		
		if(response != null && response.getSuccess()) {
			
			this.saveComics(response.getComics(), response.getId());
			this.saveEvents(response.getEvents(), response.getId());
			List<MarvelSeries> listSeries = response.getSeries();
			List<MarvelStories> lisStories = response.getStories();
			
			
		}
	}
	
	private void saveComics(List<MarvelComics> lisComics, Integer idCharacters) {
		
		List<MarvelItems> items = null;
		Comics comics = null;
		for (MarvelComics marvelComics : lisComics) {
			items = marvelComics.getItems();
			
			if(items != null && !items.isEmpty()) {
				for (MarvelItems marvelItems : items) {
					comics = new Comics();
					comics.setIdCharacter(idCharacters);
					comics.setName(marvelItems.getName());
					comics.setResources(marvelItems.getResourceURI());
					
					marvelComicsRepository.save(comics);
				}
			}
		}
	}
	
	private void saveEvents(List<MarvelEvents> lisevEnts, Integer idCharacters) {
		
		List<MarvelItems> items = null;
		Events events = null;
		 for (MarvelEvents marvelEvents : lisevEnts) {
			 items = marvelEvents.getItems();
			 if(items != null && !items.isEmpty()) {
				 for (MarvelItems marvelItems : items) {
					 events = new Events();
					 events.setIdCharacter(idCharacters);
					 events.setName(marvelItems.getName());
					 events.setResources(marvelItems.getResourceURI());
					 
					 marvelEventsRepository.save(events);
				}
			 }
		}
	}

}
