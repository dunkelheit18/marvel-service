package com.mx.application.marvel.service.model;

/**
 * @author jahernandezg
 */
public class MarvelCharacters {

	private Integer code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private MarvelData marvelData;
	private String etag;
	
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the copyright
	 */
	public String getCopyright() {
		return copyright;
	}
	/**
	 * @param copyright the copyright to set
	 */
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	/**
	 * @return the attributionText
	 */
	public String getAttributionText() {
		return attributionText;
	}
	/**
	 * @param attributionText the attributionText to set
	 */
	public void setAttributionText(String attributionText) {
		this.attributionText = attributionText;
	}
	/**
	 * @return the attributionHTML
	 */
	public String getAttributionHTML() {
		return attributionHTML;
	}
	/**
	 * @param attributionHTML the attributionHTML to set
	 */
	public void setAttributionHTML(String attributionHTML) {
		this.attributionHTML = attributionHTML;
	}
	/**
	 * @return the etag
	 */
	public String getEtag() {
		return etag;
	}
	/**
	 * @param etag the etag to set
	 */
	public void setEtag(String etag) {
		this.etag = etag;
	}
	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * @return the data
	 */
	public MarvelData getData() {
		return marvelData;
	}
	/**
	 * @param marvelData the data to set
	 */
	public void setData(MarvelData marvelData) {
		this.marvelData = marvelData;
	}
}
