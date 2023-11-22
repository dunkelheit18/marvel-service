package com.mx.application.marvel.api.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mx.application.marvel.api.persistence.entity.Comics;
import com.mx.application.marvel.api.persistence.repository.MarvelComicsRepository;

/**
 * @author jahernandezg
 */
@SpringBootTest
public class MarvelComicsRepositoryTest {

	@Autowired
	private  MarvelComicsRepository marvelComicsRepository;
	
	private Comics comics;
	
	@BeforeEach
	public void setUp() {
		comics = new Comics();
		
		comics.setIdCharacter(1009664);
		comics.setName("Age of Heroes (2010) #1");
		comics.setResources("http://gateway.marvel.com/v1/public/comics/30090");
	}
	
	@Test
	public void saveComics() {
		Comics saveComic = marvelComicsRepository.save(comics);
		assertNotNull(saveComic);
		assertNotNull(saveComic.getId());
	}
}
