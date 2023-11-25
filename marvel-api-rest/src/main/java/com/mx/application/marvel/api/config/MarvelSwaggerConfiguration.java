package com.mx.application.marvel.api.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author jahernandezg
 */
@Configuration
@EnableSwagger2
public class MarvelSwaggerConfiguration {

	@Bean
	public Docket generateDocket() {
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.mx.application.marvel.api.application.controller"))
				.paths(PathSelectors.any()).build()
				.apiInfo(new ApiInfo("Marvel API", "Maerverl Data Extarct", "1.0", "",
						 new Contact("Aaron Hernandez", "", "aaron.hg@outlook.com"), "", "", 
						 Collections.emptyList()));
	}
}
