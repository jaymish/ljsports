package com.openTournament;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.openTournament.OpenTournament;


@SpringBootApplication
public class OpenTournament extends SpringBootServletInitializer{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OpenTournament.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OpenTournament.class, args);
	}
}
