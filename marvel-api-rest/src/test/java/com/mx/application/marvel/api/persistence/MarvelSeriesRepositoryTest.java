package com.mx.application.marvel.api.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.application.marvel.api.persistence.entity.Series;
import com.mx.application.marvel.api.persistence.repository.MarvelSeriesRepository;

/**
 * @author jahernandezg
 */
@SpringBootTest
public class MarvelSeriesRepositoryTest {

	@Autowired
	private  MarvelSeriesRepository marvelSeriesRepository;
	
	private Series series;
	
	@BeforeEach
	public void setUp() {
		series = Series.builder()
				.idCharacter(1009664)
				.name("A+X (2012 - 2014)")
				.resources("http://gateway.marvel.com/v1/public/series/16450")
				.build();
	}
	
	@Test
	public void saveSeries() {
		Series saveSeries = marvelSeriesRepository.save(series);
		assertNotNull(saveSeries);
		assertNotNull(saveSeries.getId());
	}
}
