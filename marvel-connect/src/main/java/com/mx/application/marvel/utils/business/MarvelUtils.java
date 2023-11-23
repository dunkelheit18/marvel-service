package com.mx.application.marvel.utils.business;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.mx.application.marvel.service.model.MarvelCharacters;
import com.mx.application.marvel.service.model.MarvelComics;
import com.mx.application.marvel.service.model.MarvelEvents;
import com.mx.application.marvel.service.model.MarvelItems;
import com.mx.application.marvel.service.model.MarvelSeries;
import com.mx.application.marvel.service.model.MarvelStories;

/**
 * @author jahernandezg
 */
public class MarvelUtils {

	public static String[] getCharacterData(MarvelCharacters characters) {
		
		String id = "";
		String name = "";
		String description = "";
		String modified = "";
		
		LinkedHashMap<?, ?> data = characters.getData().getResults().stream()
				.filter(p -> p instanceof LinkedHashMap<?,?>)
				.map(o -> (LinkedHashMap<?,?>) o)
				.collect(Collectors.toList()).get(0);
		
		for (Entry<?,?> entry : data.entrySet()) {
			if(id.isEmpty()) {
				id = entry.getKey().toString().equals("id") ? entry.getValue().toString() : "";
			}
			if(name.isEmpty()) {
				name = entry.getKey().toString().equals("name") ? entry.getValue().toString() : "";
			}
			if(description.isEmpty()) {
				description = entry.getKey().toString().equals("description") ? entry.getValue().toString() : "";
			}
			if(modified.isEmpty()) {
				modified = entry.getKey().toString().equals("modified") ? entry.getValue().toString() : "";
			}
		}
		
		return new String[] {id, name, description, modified};
	}
	
	public static List<MarvelStories> getStoriesItems(MarvelCharacters characters) {
		
		LinkedHashMap<?, ?> data = characters.getData().getResults().stream()
				.filter(p -> p instanceof LinkedHashMap<?,?>)
				.map(o -> (LinkedHashMap<?,?>) o)
				.collect(Collectors.toList()).get(0);
			
		List<MarvelStories> storiestsList = data.entrySet().stream()
				.filter(e -> e.getKey().toString().equals("series"))
				.map(e -> setoriesToMap(e.getValue())).collect(Collectors.toList()).get(0);
		
		return storiestsList;
	}
	
	private  static List<MarvelStories> setoriesToMap(Object object) {
		
		LinkedHashMap<?, ?> comicsHash = (LinkedHashMap<?, ?>) object;
		
		return comicsHash.entrySet().stream()
				.map(c -> toStories(c)).collect(Collectors.toList());
	}
	
	private static MarvelStories toStories(Entry<?, ?> entry){
		MarvelStories stories = new MarvelStories();
		
		stories.setAvailable(entry.getKey().toString().equals("available") ?
				Integer.parseInt(entry.getValue().toString()) : null);
		stories.setCollectionURI(entry.getKey().toString().equals("collectionURI") ?
				entry.getValue().toString() : "");
		
		if(entry.getKey().equals("items")) {
			stories.setItems(getItems(entry.getValue()));
		}
		
		return stories;
	}
	
	public static List<MarvelSeries> getSeriesItems(MarvelCharacters characters) {
		
		LinkedHashMap<?, ?> data = characters.getData().getResults().stream()
				.filter(p -> p instanceof LinkedHashMap<?,?>)
				.map(o -> (LinkedHashMap<?,?>) o)
				.collect(Collectors.toList()).get(0);
			
		List<MarvelSeries> eventsList = data.entrySet().stream()
				.filter(e -> e.getKey().toString().equals("series"))
				.map(e -> seriesToMap(e.getValue())).collect(Collectors.toList()).get(0);
		
		return eventsList;
	}
	
	private static List<MarvelSeries> seriesToMap(Object object) {
		
		LinkedHashMap<?, ?> comicsHash = (LinkedHashMap<?, ?>) object;
		
		return comicsHash.entrySet().stream()
				.map(c -> toSeries(c)).collect(Collectors.toList());
	}
	
	private static MarvelSeries toSeries(Entry<?, ?> entry){
		MarvelSeries series = new MarvelSeries();
		
		series.setAvailable(entry.getKey().toString().equals("available") ?
				Integer.parseInt(entry.getValue().toString()) : null);
		series.setCollectionURI(entry.getKey().toString().equals("collectionURI") ?
				entry.getValue().toString() : "");
		
		if(entry.getKey().equals("items")) {
			series.setItems(getItems(entry.getValue()));
		}
		
		return series;
	}
	
	
	public static List<MarvelEvents> getEventsItems(MarvelCharacters characters) {
		
		LinkedHashMap<?, ?> data = characters.getData().getResults().stream()
				.filter(p -> p instanceof LinkedHashMap<?,?>)
				.map(o -> (LinkedHashMap<?,?>) o)
				.collect(Collectors.toList()).get(0);
			
		List<MarvelEvents> eventsList = data.entrySet().stream()
				.filter(e -> e.getKey().toString().equals("events"))
				.map(e -> eventsToMap(e.getValue())).collect(Collectors.toList()).get(0);
		
		return eventsList;
	}
	
	private static List<MarvelEvents> eventsToMap(Object object) {
		
		LinkedHashMap<?, ?> comicsHash = (LinkedHashMap<?, ?>) object;
		
		return comicsHash.entrySet().stream()
				.map(c -> toEvents(c)).collect(Collectors.toList());
	}
	
	private static MarvelEvents toEvents(Entry<?, ?> entry){
		MarvelEvents events = new MarvelEvents();
		
		events.setAvailable(entry.getKey().toString().equals("available") ?
				Integer.parseInt(entry.getValue().toString()) : null);
		events.setCollectionURI(entry.getKey().toString().equals("collectionURI") ?
				entry.getValue().toString() : "");
		
		if(entry.getKey().equals("items")) {
			events.setItems(getItems(entry.getValue()));
		}
		
		return events;
	}
	
	public static List<MarvelComics> getComicsItems(MarvelCharacters characters) {
	
		LinkedHashMap<?, ?> data = characters.getData().getResults().stream()
				.filter(p -> p instanceof LinkedHashMap<?,?>)
				.map(o -> (LinkedHashMap<?,?>) o)
				.collect(Collectors.toList()).get(0);
			
		List<MarvelComics> comicList = data.entrySet().stream()
				.filter(e -> e.getKey().toString().equals("comics"))
				.map(e -> comicsToMap(e.getValue())).collect(Collectors.toList()).get(0);
		
		return comicList;
	}
	
	private static List<MarvelComics> comicsToMap(Object object) {
		
		LinkedHashMap<?, ?> comicsHash = (LinkedHashMap<?, ?>) object;
		
		return comicsHash.entrySet().stream()
				.map(c -> toComic(c)).collect(Collectors.toList());
	}
	
	private static MarvelComics toComic(Entry<?, ?> entry){
		MarvelComics comic = new MarvelComics();
		
		comic.setAvailable(entry.getKey().toString().equals("available") ?
				Integer.parseInt(entry.getValue().toString()) : null);
		comic.setCollectionURI(entry.getKey().toString().equals("collectionURI") ?
				entry.getValue().toString() : "");
		
		if(entry.getKey().equals("items")) {
			comic.setItems(getItems(entry.getValue()));
		}
		
		return comic;
	}
	
	private static List<MarvelItems> getItems(Object object) {	

		List<MarvelItems> itemsMarvelList = new ArrayList<>();
		List<?> itemsList = (List<?>) object;
		
		for (Object obj : itemsList) {
			
			MarvelItems item = new MarvelItems();;
			LinkedHashMap<?, ?> items = (LinkedHashMap<?, ?>) obj;
			
			items.entrySet().stream().forEach(e -> {
				if(e.getKey().toString().equals("name")) {
					item.setName(e.getValue().toString());
				}
				if(e.getKey().toString().equals("resourceURI")) {
					item.setResourceURI(e.getValue().toString());
				}
			});
			
			itemsMarvelList.add(item);
		}
		
		
		return itemsMarvelList;
	}
}
