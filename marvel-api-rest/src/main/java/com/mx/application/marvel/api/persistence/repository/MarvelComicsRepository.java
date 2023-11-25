package com.mx.application.marvel.api.persistence.repository;

import static com.mx.application.marvel.api.persistence.constants.MarvelQuerys.ALL_COMICS;

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

	@Query(nativeQuery = true, value = ALL_COMICS)
	List<Object> getComicsAll(@Param("idCharacter") Integer idCharacter);
	
	default List<Comics> getAllbyId(Integer idCharacter){
	
		List<Object> objects = getComicsAll(idCharacter);
		
		return objects.stream().map(o -> {
			
			Object[] obj = ObjectUtils.toObjectArray(o);
			
			return Comics.builder()
					.resources(obj[0].toString())
					.id(Integer.parseInt(obj[1].toString()))
					.idCharacter(Integer.parseInt(obj[2].toString()))
					.name(obj[3].toString())
					.build();
			
			
		}).collect(Collectors.toList());
		
	}
}
