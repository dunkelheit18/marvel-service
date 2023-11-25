package com.mx.application.marvel.api.business.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.mx.application.marvel.api.application.model.MarvelCharcterResponse;
import com.mx.application.marvel.api.business.service.MarvelExctractService;
import com.mx.application.marvel.api.business.service.MarvelExtractItemsService;
import com.mx.application.marvel.api.persistence.entity.Comics;
import com.mx.application.marvel.api.persistence.entity.Events;
import com.mx.application.marvel.api.persistence.entity.Series;
import com.mx.application.marvel.api.persistence.entity.Stories;
import com.mx.application.marvel.service.model.MarvelCharacteresResponse;
import com.mx.application.marvel.service.model.MarvelComics;
import com.mx.application.marvel.service.model.MarvelEvents;
import com.mx.application.marvel.service.model.MarvelSeries;
import com.mx.application.marvel.service.model.MarvelStories;

/**
 * @author jahernandezg
 */
@Service
public class MarvelExtractItemsServiceImpl implements MarvelExtractItemsService {

	@Autowired
	private MarvelExctractService marvelExctractService;
	
	@Override
	public MarvelCharcterResponse getItemsByName(String Name) {
		
		MarvelCharacteresResponse response = marvelExctractService.extractDataByName(Name);
		
		return MarvelCharcterResponse.builder()
				.Id(response.getId())
				.name(response.getName())
				.description(response.getDescription())
				.modified(response.getModified())
				.success(response.getSuccess())
				.comics(this.getComics(response.getComics(), response.getId()))
				.events(this.getEvents(response.getEvents(), response.getId()))
				.series(this.getSeries(response.getSeries(), response.getId()))
				.stories(this.saveStories(response.getStories(), response.getId()))
				.build();
	}

	@Override
	public MarvelCharcterResponse getItemsById(Integer idCharacters) {
		
		MarvelCharacteresResponse response = marvelExctractService.extractDataById(idCharacters);
		
		return MarvelCharcterResponse.builder()
				.Id(response.getId())
				.name(response.getName())
				.description(response.getDescription())
				.modified(response.getModified())
				.success(response.getSuccess())
				.comics(this.getComics(response.getComics(), response.getId()))
				.events(this.getEvents(response.getEvents(), response.getId()))
				.series(this.getSeries(response.getSeries(), response.getId()))
				.stories(this.saveStories(response.getStories(), response.getId()))
				.build();
	}

	private List<Comics> getComics(List<MarvelComics> lisComics, Integer idCharacters) {
		
		if(!CollectionUtils.isEmpty(lisComics)) {
			return lisComics.stream().filter
					(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {		
				return i.getItems().stream().map(mi -> {				
					return Comics.builder()
							.idCharacter(idCharacters)
							.name(mi.getName())
							.resources(mi.getResourceURI())
							.build();
				}).toList();
			}).toList().get(0);
		}
		
		return Collections.emptyList();
	}
	
	private List<Events> getEvents(List<MarvelEvents> lisevEnts, Integer idCharacters) {
		 
		if(!CollectionUtils.isEmpty(lisevEnts)) {
			return lisevEnts.stream().filter
					(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {
				return i.getItems().stream().map(e -> {

					 return Events.builder()
								.idCharacter(idCharacters)
								.name(e.getName())
								.resources(e.getResourceURI())
								.build();
				 }).toList();
			 }).toList().get(0);
			
		}
		
		return Collections.emptyList();
	}
	
	private List<Series> getSeries(List<MarvelSeries> lisevSeries, Integer idCharacters) {
		
		 if(!CollectionUtils.isEmpty(lisevSeries)) {
			 return lisevSeries.stream().filter
						(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {
					return i.getItems().stream().map(s -> {
						 return Series.builder()
									.idCharacter(idCharacters)
									.name(s.getName())
									.resources(s.getResourceURI())
									.build();
					}).toList();
				}).toList().get(0);
				
		 }
		 
		 return Collections.emptyList();
	}
	
	private List<Stories> saveStories(List<MarvelStories> lisStories, Integer idCharacters) {
		
		  if(!CollectionUtils.isEmpty(lisStories)) {
			  return lisStories.stream().filter
						(n -> !CollectionUtils.isEmpty(n.getItems())).map(i -> {
					return i.getItems().stream().map(s -> {
						return Stories.builder()
								.idCharacter(idCharacters)
								.name(s.getName())
								.resources(s.getResourceURI())
								.build();
					}).toList();	
				}).collect(Collectors.toList()).get(0);
		  }
		  
		  return Collections.emptyList();
	}
}
