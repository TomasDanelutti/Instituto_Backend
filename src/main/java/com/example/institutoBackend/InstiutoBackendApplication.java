package com.example.institutoBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class InstiutoBackendApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(InstiutoBackendApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(InstiutoBackendApplication.class, args);
	}
	
	@Bean("encoder")
	public BCryptPasswordEncoder getEncoder(){
		return new BCryptPasswordEncoder(12);
	}
}
