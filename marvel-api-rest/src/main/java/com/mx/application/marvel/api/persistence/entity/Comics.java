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
@Table(name = "COMICS")
public class Comics implements Serializable {

	private static final long serialVersionUID = -733392748603236160L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMICS")
	private Integer id;
	
	@Column(name = "ID_CHARACTERER")
	private Integer idCharacter;
	
	@Column(name = "RESOURCE_COMICS")
	private String resources;
	
	@Column(name = "NAME_COMICS")
	private String name;
}
