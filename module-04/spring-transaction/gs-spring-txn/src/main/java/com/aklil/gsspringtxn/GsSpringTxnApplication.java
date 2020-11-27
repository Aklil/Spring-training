package com.aklil.gsspringtxn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class GsSpringTxnApplication {

	public static void main(String[] args) {
		SpringApplication.run(GsSpringTxnApplication.class, args);
	}

}
