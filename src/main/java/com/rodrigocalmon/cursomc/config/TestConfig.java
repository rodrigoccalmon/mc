package com.rodrigocalmon.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rodrigocalmon.cursomc.service.DBService;
import com.rodrigocalmon.cursomc.service.EmailService;
import com.rodrigocalmon.cursomc.service.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.istantiateTestDatabase();
		return true;
	}
	@Bean
	public EmailService emailService() { 
		return new MockEmailService();
	}
}
