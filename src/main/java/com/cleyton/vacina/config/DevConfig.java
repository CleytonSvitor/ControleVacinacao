package com.cleyton.vacina.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;



@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	//private DBService dbService;
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String ddl;

	@Bean
	public boolean instanciaBD() {
		if (ddl.equals("create")) {
			//dbService.instanciaDB();
			
		}
		return false;
	}
}
