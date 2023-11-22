package com.mx.application.marvel.api.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
}
