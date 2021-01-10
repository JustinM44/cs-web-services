package com.justinmechanye.cs.cswebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication @ComponentScan(basePackages = {"com.justinmechanye.cs.cswebservices.*"})
public class CsWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsWebservicesApplication.class, args);
	}

}
