package com.mx.application.marvel.service.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jahernandezg
 */
public class MarvelData {

	private String offset;
	private String limit;
	private String total;
	private String count;
	private List<Object> results = new ArrayList<>();
	
	/**
	 * @return the offset
	 */
	public String getOffset() {
		return offset;
	}
	/**
	 * @param offset the offset to set
	 */
	public void setOffset(String offset) {
		this.offset = offset;
	}
	/**
	 * @return the limit
	 */
	public String getLimit() {
		return limit;
	}
	/**
	 * @param limit the limit to set
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}
	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
	/**
	 * @return the results
	 */
	public List<Object> getResults() {
		return results;
	}
	/**
	 * @param results the results to set
	 */
	public void setResults(List<Object> results) {
		this.results = results;
	}
}
