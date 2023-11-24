package com.mx.application.marvel.api.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.mx.application.marvel.api.business.service.MarvelExctractService;
import com.mx.application.marvel.api.business.service.MarvelProcessDataService;
import com.mx.application.marvel.api.persistence.entity.Characters;
import com.mx.application.marvel.api.persistence.entity.Comics;
import com.mx.application.marvel.api.persistence.entity.Events;
import com.mx.application.marvel.api.persistence.entity.Series;
import com.mx.application.marvel.api.persistence.entity.Stories;
import com.mx.application.marvel.api.persistence.repository.MarvelCharactersRepository;
import com.mx.application.marvel.api.persistence.repository.MarvelComicsRepository;
import com.mx.application.marvel.api.persistence.repository.MarvelEventsRepository;
import com.mx.application.marvel.api.persistence.repository.MarvelSeriesRepository;
import com.mx.application.marvel.api.persistence.repository.MarvelStoriesRepository;
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
	
	@Autowired
	private MarvelSeriesRepository marvelSeriesRepository;
	
	@Autowired
	private MarvelStoriesRepository marvelStoriesRepository;
	
	@Autowired
	private MarvelCharactersRepository marvelCharactersRepository;
	
	@Override
	public boolean saveCharactersData(String name) {
		
		boolean bandera = true;
		try {
			MarvelCharacteresResponse response = marvelExctractService.extractData(name);
			
			if(response != null && response.getSuccess()) {
				
				this.saveComics(response.getComics(), response.getId());
				this.saveEvents(response.getEvents(), response.getId());
				this.saveSeries(response.getSeries(), response.getId());
				this.saveStories(response.getStories(), response.getId());
				this.saveCharacters(response.getId(), response.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			bandera = false;
		}
		
		return bandera;
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
					marvelComicsRepository.flush();
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
					 marvelEventsRepository.flush();
				}
			 }
		}
	}
	
	private void saveSeries(List<MarvelSeries> lisevSeries, Integer idCharacters) {
		
		List<MarvelItems> items = null;
		Series series = null;
		for (MarvelSeries seriesItems : lisevSeries) {
			 items = seriesItems.getItems();
			
			 if(items != null && !items.isEmpty()) {
				 
				 for (MarvelItems marvelItems : items) {
					 series = new Series();
					 series.setIdCharacter(idCharacters);
					 series.setName(marvelItems.getName());
					 series.setResources(marvelItems.getResourceURI());
					 
					 marvelSeriesRepository.save(series);
					 marvelSeriesRepository.flush();
				}
			 }
		}
	}
	
	private void saveStories(List<MarvelStories> lisStories, Integer idCharacters) {
		
		List<MarvelItems> items = null;
		Stories stories = null;
		
		for (MarvelStories marvelStories : lisStories) {
			
			items = marvelStories.getItems();
			
			if(items != null && !items.isEmpty()) {
			
				for (MarvelItems marvelItems : items) {
					stories = new Stories();
					
					stories.setIdCharacter(idCharacters);
					stories.setName(marvelItems.getName());
					stories.setResources(marvelItems.getResourceURI());
					
					marvelStoriesRepository.save(stories);
					marvelStoriesRepository.flush();
				}
			}
		}
	}
	
	private void saveCharacters(Integer id, String name) {
			
		List<Object> listObject = marvelCharactersRepository.getAllCharactersId(id);
		
		List<Characters> listCharac = listObject.stream().map(o -> {
			
			Characters chara = new Characters();
			Object[] obj = ObjectUtils.toObjectArray(o);
			
			chara.setIdComics(Integer.parseInt(obj[0].toString()));
			chara.setIdEvents(Integer.parseInt(obj[1].toString()));
			chara.setIdSeries(Integer.parseInt(obj[2].toString()));
			chara.setIdStories(Integer.parseInt(obj[3].toString()));
			chara.setIdCharacter(id);
			chara.setNameCharacter(name);
			
			return chara;
		}).collect(Collectors.toList());
		
		listCharac.stream().forEach(c -> {
			marvelCharactersRepository.save(c);
			marvelCharactersRepository.flush();
		});
	}
}
