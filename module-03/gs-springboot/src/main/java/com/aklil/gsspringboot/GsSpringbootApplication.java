package com.aklil.gsspringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@SpringBootApplication
public class GsSpringbootApplication {

	// spring boot configures default logger
	private static Logger logger = LoggerFactory.getLogger(GsSpringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GsSpringbootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			logger.info("Beans provided by Spring Boot ======");

			String[] beanNames = context.getBeanDefinitionNames();

			Arrays.sort(beanNames); //just for convenience sort by name

			for(var beanName: beanNames)
				logger.info(beanName);
		};
	}
}
