package com.mx.application.marvel.api.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.ObjectUtils;

import com.mx.application.marvel.api.persistence.entity.Comics;

/**
 * @author jahernandezg
 */
public interface MarvelComicsRepository extends JpaRepository<Comics, Integer>{

	@Query(nativeQuery = true, value ="SELECT DISTINCT RESOURCE_COMICS,  ID_COMICS, ID_CHARACTERER, NAME_COMICS FROM COMICS WHERE ID_CHARACTERER = :idCharacter")
	List<Object> getComicsAll(@Param("idCharacter") Integer idCharacter);
	
	default List<Comics> getAllbyId(Integer idCharacter){
	
		List<Object> objects = getComicsAll(idCharacter);
		
		return objects.stream().map(o -> {
			Comics comic = new Comics();
			
			Object[] obj = ObjectUtils.toObjectArray(o);
			
			comic.setResources(obj[0].toString());
			comic.setId(Integer.parseInt(obj[1].toString()));
			comic.setIdCharacter(Integer.parseInt(obj[2].toString()));
			comic.setName(obj[3].toString());
			
			return comic;
		}).collect(Collectors.toList());
		
	}
}
