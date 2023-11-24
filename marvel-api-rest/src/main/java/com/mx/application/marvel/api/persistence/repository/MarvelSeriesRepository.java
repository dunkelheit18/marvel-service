package com.mx.application.marvel.api.persistence.repository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.util.ObjectUtils;

import com.mx.application.marvel.api.persistence.entity.Series;

/**
 * @author jahernandezg
 */
public interface MarvelSeriesRepository extends JpaRepository<Series, Integer>{

	@Query(nativeQuery = true, value = "SELECT DISTINCT RESOURCE_SERIES,  ID_SERIES, ID_CHARACTERER, NAME_SERIES FROM SERIES WHERE ID_CHARACTERER = :idCharacter")
	List<Object> getSeriesAll(@Param("idCharacter") Integer idCharacter);
	
	default List<Series> getAllbyId(@Param("idCharacter") Integer idCharacter){
		
		List<Object> objects = getSeriesAll(idCharacter);
		
		return objects.stream().map(o -> {
			Series series = new Series();
			
			Object[] obj = ObjectUtils.toObjectArray(o);
			
			series.setResources(obj[0].toString());
			series.setId(Integer.parseInt(obj[1].toString()));
			series.setIdCharacter(Integer.parseInt(obj[2].toString()));
			series.setName(obj[3].toString());
			
			return series;
			
		}).collect(Collectors.toList());
	}
}
