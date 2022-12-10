package com.cleyton.vacina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("test")
public class TesteConfig {

	@Autowired
	//private DBService dbService;

	@Bean
	public void instanciaBD() {
		//dbService.instanciaDB();
	}
}
