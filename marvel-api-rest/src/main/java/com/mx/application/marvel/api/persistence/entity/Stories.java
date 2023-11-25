package com.mx.application.marvel.api.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author jahernandezg
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Entity
@Table(name = "STORIES")
public class Stories implements Serializable {

	private static final long serialVersionUID = -733392748603236160L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_STORIES")
	private Integer id;
	
	@Column(name = "ID_CHARACTERER")
	private Integer idCharacter;
	
	@Column(name = "RESOURCE_STORIES")
	private String resources;
	
	@Column(name = "NAME_STORIES")
	private String name;
}
