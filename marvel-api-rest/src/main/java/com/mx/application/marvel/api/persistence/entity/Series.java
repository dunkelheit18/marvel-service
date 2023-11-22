package com.mx.application.marvel.api.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jahernandezg
 */
@Entity
@Table(name = "SERIES")
public class Series implements Serializable {

	private static final long serialVersionUID = -733392748603236160L;
	
	@Column(name = "ID_SERIES")
	private Integer id;
	
	@Column(name = "RESOURCE_SERIES")
	private String resources;
	
	@Column(name = "NAME_SERIES")
	private String name;
	

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
	 * @return the resources
	 */
	public String getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(String resources) {
		this.resources = resources;
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
}
