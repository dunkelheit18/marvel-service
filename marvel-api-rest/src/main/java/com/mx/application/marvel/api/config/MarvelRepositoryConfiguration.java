package com.mx.application.marvel.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.mx.application.marvel.api.persistence"})
public class MarvelRepositoryConfiguration {

}
