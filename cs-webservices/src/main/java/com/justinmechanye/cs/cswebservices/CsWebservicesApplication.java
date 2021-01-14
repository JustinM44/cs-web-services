package com.justinmechanye.cs.cswebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication @ComponentScan(basePackages = {"com.justinmechanye.cs.cswebservices.*"})
@EnableSwagger2
public class CsWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsWebservicesApplication.class, args);
	}

}
