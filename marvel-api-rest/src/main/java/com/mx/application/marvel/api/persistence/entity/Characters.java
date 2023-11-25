package com.mx.application.marvel.api.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author jahernandezg
 */
@Getter
@Setter
@Builder
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
}
