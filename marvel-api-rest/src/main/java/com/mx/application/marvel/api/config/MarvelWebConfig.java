package com.mx.application.marvel.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jahernandezg
 */
@Configuration
public class MarvelWebConfig implements WebMvcConfigurer  {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/**")
			.allowedOrigins("http://localhost:4200")
			.allowedMethods("GET", "POST")
			.allowedHeaders("Origin", "Content-Type", "Accept")
			.allowCredentials(true);
	}
}
