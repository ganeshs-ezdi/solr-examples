package com.examples.solr.connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.examples.solr.*")
public class CloudConnectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudConnectionApplication.class, args);
	}
}
