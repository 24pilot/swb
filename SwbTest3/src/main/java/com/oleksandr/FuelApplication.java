package com.oleksandr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * @author oleksandr
 *
 */
@SpringBootApplication
public class FuelApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FuelApplication.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(FuelApplication.class, args);
	}

}
