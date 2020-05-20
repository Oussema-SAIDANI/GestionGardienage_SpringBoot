package com.oussema.stage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StageApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(StageApplication.class, args);
				
	}

}

