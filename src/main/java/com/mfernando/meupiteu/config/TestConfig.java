package com.mfernando.meupiteu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.mfernando.meupiteu.services.DBService;
import com.mfernando.meupiteu.services.EmailService;
import com.mfernando.meupiteu.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService dbService;
	@Bean
	public boolean instantiateDatabase() {
		dbService.instantiateTestDatabase();
		return true;
	}
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
}
