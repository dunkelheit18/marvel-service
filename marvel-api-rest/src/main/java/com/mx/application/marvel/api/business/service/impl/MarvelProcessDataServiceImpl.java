package com.mx.application.marvel.api.business.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
	public boolean saveCharactersDataByName(String name) {
		
		boolean bandera = true;
		try {
			MarvelCharacteresResponse response = marvelExctractService.extractDataByName(name);
			
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
	
	@Override
	public boolean saveCharactersDataById(Integer id) {
		boolean bandera = true;
		try {
			MarvelCharacteresResponse response = marvelExctractService.extractDataById(id);
			
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
	
		if(!CollectionUtils.isEmpty(lisComics)) {
			List<Comics> comicsList =  lisComics.stream().filter
					(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {		
				return i.getItems().stream().map(mi -> {				
					return Comics.builder()
							.idCharacter(idCharacters)
							.name(mi.getName())
							.resources(mi.getResourceURI())
							.build();
				}).toList();
			}).toList().get(0);
			
			marvelComicsRepository.saveAll(comicsList);
		}
	}
	
	private void saveEvents(List<MarvelEvents> lisevEnts, Integer idCharacters) {
		 
		if(!CollectionUtils.isEmpty(lisevEnts)) {
			List<Events> eventsList = lisevEnts.stream().filter
					(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {
				return i.getItems().stream().map(e -> {

					 return Events.builder()
								.idCharacter(idCharacters)
								.name(e.getName())
								.resources(e.getResourceURI())
								.build();
				 }).toList();
			 }).toList().get(0);
			
			 marvelEventsRepository.saveAll(eventsList);
		}
	}
	
	private void saveSeries(List<MarvelSeries> lisevSeries, Integer idCharacters) {
		
	 if(!CollectionUtils.isEmpty(lisevSeries)) {
		 List<Series> seriesList = lisevSeries.stream().filter
					(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {
				return i.getItems().stream().map(s -> {
					 return Series.builder()
								.idCharacter(idCharacters)
								.name(s.getName())
								.resources(s.getResourceURI())
								.build();
				}).toList();
			}).toList().get(0);
			
			marvelSeriesRepository.saveAll(seriesList);
	 }
	}
	
	private void saveStories(List<MarvelStories> lisStories, Integer idCharacters) {
		
	  if(!CollectionUtils.isEmpty(lisStories)) {
		  List<Stories> storiesList =	lisStories.stream().filter
					(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {
				return i.getItems().stream().map(s -> {
					return Stories.builder()
							.idCharacter(idCharacters)
							.name(s.getName())
							.resources(s.getResourceURI())
							.build();
				}).toList();	
			}).collect(Collectors.toList()).get(0);
			
			marvelStoriesRepository.saveAll(storiesList);
	  }
	}
	
	private void saveCharacters(Integer id, String name) {
			
		List<Object> listObject = marvelCharactersRepository.getAllCharactersId(id);
		
		if(!CollectionUtils.isEmpty(listObject)) {
			List<Characters> listCharac = listObject.stream().filter(n -> n != null).map(o -> {		
				Object[] obj = ObjectUtils.toObjectArray(o);
				
				return obj != null && obj.length > 0 ? Characters.builder()
						.idComics(Integer.parseInt(obj[0].toString()))
						.idEvents(Integer.parseInt(obj[1].toString()))
						.idSeries(Integer.parseInt(obj[2].toString()))
						.idStories(Integer.parseInt(obj[3].toString()))
						.idCharacter(id)
						.nameCharacter(name)
						.build() : Characters.builder().build();
			}).collect(Collectors.toList());
			
			marvelCharactersRepository.saveAll(listCharac);
		}
	}
}
