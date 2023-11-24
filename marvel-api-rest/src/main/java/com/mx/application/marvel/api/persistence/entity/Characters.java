package com.mx.application.marvel.api.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jahernandezg
 */
@Entity
@Table(name = "CHARACTERS")
public class Characters implements Serializable {

	private static final long serialVersionUID = -2488449587791101190L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "ID_CHARACTERER")
	private Integer idCharacter;
	
	@Column(name = "ID_COMICS")
	private Integer idComics;
	
	@Column(name = "ID_EVENTS")
	private Integer idEvents;
	
	@Column(name = "ID_SERIES")
	private Integer idSeries;
	
	@Column(name = "ID_STORIES")
	private Integer idStories;
	
	@Column(name = "NAME_CHARACTER")
	private String nameCharacter;
	

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
	 * @return the idCharacter
	 */
	public Integer getIdCharacter() {
		return idCharacter;
	}

	/**
	 * @param idCharacter the idCharacter to set
	 */
	public void setIdCharacter(Integer idCharacter) {
		this.idCharacter = idCharacter;
	}

	/**
	 * @return the idComics
	 */
	public Integer getIdComics() {
		return idComics;
	}

	/**
	 * @param idComics the idComics to set
	 */
	public void setIdComics(Integer idComics) {
		this.idComics = idComics;
	}

	/**
	 * @return the idEvents
	 */
	public Integer getIdEvents() {
		return idEvents;
	}

	/**
	 * @param idEvents the idEvents to set
	 */
	public void setIdEvents(Integer idEvents) {
		this.idEvents = idEvents;
	}

	/**
	 * @return the idSeries
	 */
	public Integer getIdSeries() {
		return idSeries;
	}

	/**
	 * @param idSeries the idSeries to set
	 */
	public void setIdSeries(Integer idSeries) {
		this.idSeries = idSeries;
	}

	/**
	 * @return the idStories
	 */
	public Integer getIdStories() {
		return idStories;
	}

	/**
	 * @param idStories the idStories to set
	 */
	public void setIdStories(Integer idStories) {
		this.idStories = idStories;
	}

	/**
	 * @return the nameCharacter
	 */
	public String getNameCharacter() {
		return nameCharacter;
	}

	/**
	 * @param nameCharacter the nameCharacter to set
	 */
	public void setNameCharacter(String nameCharacter) {
		this.nameCharacter = nameCharacter;
	}
}
