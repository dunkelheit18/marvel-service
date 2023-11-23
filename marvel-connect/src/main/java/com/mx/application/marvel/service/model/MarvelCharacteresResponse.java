package com.mx.application.marvel.service.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author jahernandezg 
 */
public class MarvelCharacteresResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Boolean success;
	private Integer Id;
	private String name;
	private String description;
	private String modified;
	private MarvelCharacters marvelCharacters;
	private List<MarvelComics> comics;
	private List<MarvelEvents> events;
	private List<MarvelStories> stories;
	private List<MarvelSeries> series;
	
	/**
	 * @return the success
	 */
	public Boolean getSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	/**
	 * @return the marvelCharacters
	 */
	public MarvelCharacters getMarvelCharacters() {
		return marvelCharacters;
	}
	/**
	 * @param marvelCharacters the marvelCharacters to set
	 */
	public void setMarvelCharacters(MarvelCharacters marvelCharacters) {
		this.marvelCharacters = marvelCharacters;
	}
	/**
	 * @return the comics
	 */
	public List<MarvelComics> getComics() {
		return comics;
	}
	/**
	 * @param comics the comics to set
	 */
	public void setComics(List<MarvelComics> comics) {
		this.comics = comics;
	}
	/**
	 * @return the events
	 */
	public List<MarvelEvents> getEvents() {
		return events;
	}
	/**
	 * @param events the events to set
	 */
	public void setEvents(List<MarvelEvents> events) {
		this.events = events;
	}
	/**
	 * @return the stories
	 */
	public List<MarvelStories> getStories() {
		return stories;
	}
	/**
	 * @param stories the stories to set
	 */
	public void setStories(List<MarvelStories> stories) {
		this.stories = stories;
	}
	/**
	 * @return the series
	 */
	public List<MarvelSeries> getSeries() {
		return series;
	}
	/**
	 * @param series the series to set
	 */
	public void setSeries(List<MarvelSeries> series) {
		this.series = series;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		Id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the modified
	 */
	public String getModified() {
		return modified;
	}
	/**
	 * @param modified the modified to set
	 */
	public void setModified(String modified) {
		this.modified = modified;
	}
}
