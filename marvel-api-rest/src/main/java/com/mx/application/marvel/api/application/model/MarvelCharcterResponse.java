package com.mx.application.marvel.api.application.model;

import java.io.Serializable;
import java.util.List;

import com.mx.application.marvel.service.model.MarvelComics;
import com.mx.application.marvel.service.model.MarvelEvents;
import com.mx.application.marvel.service.model.MarvelSeries;
import com.mx.application.marvel.service.model.MarvelStories;

import lombok.Builder;
import lombok.Data;

/**
 * @author jahernandezg
 */
@Data
@Builder
public class MarvelCharcterResponse implements Serializable {

	private static final long serialVersionUID = -3881312075206252369L;

	private Boolean success;
	private Integer Id;
	private String name;
	private String description;
	private String modified;
	private List<MarvelComics> comics;
	private List<MarvelEvents> events;
	private List<MarvelStories> stories;
	private List<MarvelSeries> series;
}
