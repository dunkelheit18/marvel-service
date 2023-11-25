package com.mx.application.marvel.api.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.application.marvel.api.persistence.entity.Events;
import com.mx.application.marvel.api.persistence.repository.MarvelEventsRepository;

/**
 * @author jahernandezg
 */
@SpringBootTest
public class MarvelEventsRepositoryTest {

	@Autowired
	private  MarvelEventsRepository marvelEventsRepository;
	
	private Events events;
	
	@BeforeEach
	public void setUp() {
		events = Events.builder()
				.idCharacter(1009664)
				.name("Acts of Vengeance!")
				.resources("http://gateway.marvel.com/v1/public/events/116")
				.build();
	}
	
	@Test
	public void saveEvents() {
		Events saveEvents = marvelEventsRepository.save(events);
		assertNotNull(saveEvents);
		assertNotNull(saveEvents.getId());
	}
}
