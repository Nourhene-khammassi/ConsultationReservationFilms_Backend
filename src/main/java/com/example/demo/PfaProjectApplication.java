package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.service.AuthenticationService;

@SpringBootApplication
@EnableJpaAuditing // ajout les deux champs de abstract entity  authaumatiquement
// pour ajouter meth create admin il faut ajouter : extends SpringBootServletInitializer implements CommandLineRunner
public class PfaProjectApplication extends SpringBootServletInitializer implements CommandLineRunner{
	@Autowired
	@Lazy // ajouter la plus important 
	AuthenticationService userService;
	public static void main(String[] args) {
		SpringApplication.run(PfaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createadmine();
		
	}

}
