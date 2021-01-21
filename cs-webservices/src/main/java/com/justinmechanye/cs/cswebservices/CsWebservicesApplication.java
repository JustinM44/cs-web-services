package com.justinmechanye.cs.cswebservices;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.justinmechanye.cs.cswebservices.Services.JWTAuthFilter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication @ComponentScan(basePackages = {"com.justinmechanye.cs.cswebservices.*"})
@EnableSwagger2
public class CsWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CsWebservicesApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build()
				.securitySchemes(Arrays.asList(apiKey()));
	}
	
	private ApiKey apiKey() {
		return new ApiKey("jwtToken", "Authorization", "header");
	}
	
	@Configuration
	@EnableWebSecurity
	public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
		private final String[] NOAUTH = {
				"/swagger-ui/index.html",
				"/swagger-resources",
				"/swagger-resources/**",
				"/api/authservices/login",
				"/api/movies/getMovies",
				"/api/movies/getMovies/**",
				"/api/movies/getMovie/**",
				"/swagger-ui/**",
				"/v2/api-docs"
		};
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
			.addFilterAfter(new JWTAuthFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
			.antMatchers(NOAUTH).permitAll()
			.anyRequest().authenticated();
		}
		
	}

}
