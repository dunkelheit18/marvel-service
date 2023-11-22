package com.mx.application.marvel.api.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.application.marvel.api.persistence.entity.Stories;
import com.mx.application.marvel.api.persistence.repository.MarvelStoriesRepository;

/**
 * @author jahernandezg
 */
@SpringBootTest
public class MarvelStoriesRepositoryTest {

	@Autowired
	private  MarvelStoriesRepository marvelStoriesRepository;
	
	private Stories stories;
	
	@BeforeEach
	public void setUp() {
		stories = new Stories();
		
		stories.setIdCharacter(1009664);
		stories.setName("THOR (1998) #76");
		stories.setResources("http://gateway.marvel.com/v1/public/stories/876");
	}
	
	@Test
	public void saveStories() {
		Stories saveStories = marvelStoriesRepository.save(stories);
		assertNotNull(saveStories);
		assertNotNull(saveStories.getId());
	}
}
