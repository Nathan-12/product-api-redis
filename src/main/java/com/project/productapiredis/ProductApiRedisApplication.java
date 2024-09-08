package com.project.productapiredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductApiRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductApiRedisApplication.class, args);
	}

}
