package com.mx.application.marvel.api.persistence.repository;

import static com.mx.application.marvel.api.persistence.constants.MarvelQuerys.ALL_STORIES;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.ObjectUtils;

import com.mx.application.marvel.api.persistence.entity.Stories;

/**
 * @author jahernandezg
 */
public interface MarvelStoriesRepository extends JpaRepository<Stories, Integer>{

	@Query(nativeQuery = true, value = ALL_STORIES)
	List<Object> getStoriessAll(@Param("idCharacter") Integer idCharacter);
	
	default List<Stories> getAllbyId(@Param("idCharacter") Integer idCharacter){
		
		List<Object> objects = getStoriessAll(idCharacter);
		
		return objects.stream().map(o -> {
			
			Object[] obj = ObjectUtils.toObjectArray(o);
			
			return Stories.builder()
					.resources(obj[0].toString())
					.id(Integer.parseInt(obj[1].toString()))
					.idCharacter(Integer.parseInt(obj[2].toString()))
					.name(obj[3].toString())
					.build();
			
		}).collect(Collectors.toList());
	}
}
