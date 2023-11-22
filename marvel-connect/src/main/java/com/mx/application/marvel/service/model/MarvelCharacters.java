package com.mx.application.marvel.service.model;

import java.io.Serializable;
import java.util.Date;

/**
 *	@author jahernandezg 
 */
public class MarvelCharacters implements Serializable {

	private static final long serialVersionUID = -209001465022937020L;
	
	private Integer id;
	private String name;
	private String description;
	private Date modified;
	private MarvelComics comics;
	private MarvelEvents events;
	private MarvelSeries series;
	private MarvelStories stories;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	public Date getModified() {
		return modified;
	}
	/**
	 * @param modified the modified to set
	 */
	public void setModified(Date modified) {
		this.modified = modified;
	}
	/**
	 * @return the comics
	 */
	public MarvelComics getComics() {
		return comics;
	}
	/**
	 * @param comics the comics to set
	 */
	public void setComics(MarvelComics comics) {
		this.comics = comics;
	}
	/**
	 * @return the events
	 */
	public MarvelEvents getEvents() {
		return events;
	}
	/**
	 * @param events the events to set
	 */
	public void setEvents(MarvelEvents events) {
		this.events = events;
	}
	/**
	 * @return the series
	 */
	public MarvelSeries getSeries() {
		return series;
	}
	/**
	 * @param series the series to set
	 */
	public void setSeries(MarvelSeries series) {
		this.series = series;
	}
	/**
	 * @return the stories
	 */
	public MarvelStories getStories() {
		return stories;
	}
	/**
	 * @param stories the stories to set
	 */
	public void setStories(MarvelStories stories) {
		this.stories = stories;
	}
}
