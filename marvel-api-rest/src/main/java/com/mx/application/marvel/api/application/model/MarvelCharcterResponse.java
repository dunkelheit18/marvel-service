package com.mx.application.marvel.api.application.model;

import java.io.Serializable;
import java.util.List;

import com.mx.application.marvel.api.persistence.entity.Comics;
import com.mx.application.marvel.api.persistence.entity.Events;
import com.mx.application.marvel.api.persistence.entity.Series;
import com.mx.application.marvel.api.persistence.entity.Stories;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * @author jahernandezg
 */
@Data
@SuperBuilder
public class MarvelCharcterResponse implements Serializable {

	private static final long serialVersionUID = -3881312075206252369L;

	private Boolean success;
	private Integer Id;
	private String name;
	private String description;
	private String modified;
	private List<Comics> comics;
	private List<Events> events;
	private List<Stories> stories;
	private List<Series> series;
}
