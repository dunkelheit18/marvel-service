/**
 * @author jahernandezg
 */
package com.mx.application.marvel.service.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author jahernandezg
 */
public class MarvelStories implements Serializable {

	private static final long serialVersionUID = -7029836885114597712L;
	
	private Integer available;
	private String collectionURI;
	private List<MarvelItems> items;
	
	/**
	 * @return the available
	 */
	public Integer getAvailable() {
		return available;
	}
	/**
	 * @param available the available to set
	 */
	public void setAvailable(Integer available) {
		this.available = available;
	}
	/**
	 * @return the collectionURI
	 */
	public String getCollectionURI() {
		return collectionURI;
	}
	/**
	 * @param collectionURI the collectionURI to set
	 */
	public void setCollectionURI(String collectionURI) {
		this.collectionURI = collectionURI;
	}
	/**
	 * @return the items
	 */
	public List<MarvelItems> getItems() {
		return items;
	}
	/**
	 * @param items the items to set
	 */
	public void setItems(List<MarvelItems> items) {
		this.items = items;
	}
}
