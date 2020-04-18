package com.assignment.wasteless;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.assignment.persistence_layer.repository")
@EntityScan("com.assignment.business_layer.entity")
@SpringBootApplication(scanBasePackages = "com.assignment")
public class WastelessApplication {

	public static void main(String[] args) {
		SpringApplication.run(WastelessApplication.class, args);
	}

}
