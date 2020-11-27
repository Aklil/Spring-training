package com.aklil.gsspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.stream.Stream;

@SpringBootApplication
public class GsSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsSpringbootApplication.class, args);
	}

	public CommandLineRunner commandLineRunner(ApplicationContext context){
		return args -> {
			System.out.println("Beans provided by Spring Boot ======");

			String[] beanNames = context.getBeanDefinitionNames();

			Arrays.sort(beanNames); //just for convenience sort by name

			for(var beanName: beanNames)
				System.out.println(beanName);
		};
	}

}


