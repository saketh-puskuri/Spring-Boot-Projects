package com.example.ExceptionHandling;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableCaching
@SpringBootApplication
@EnableSwagger2
public class ExceptionHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionHandlingApplication.class, args);
	}
	@Bean 
	public Docket swaggerConfiguration() { 
	  return new Docket(DocumentationType.SWAGGER_2).select().
			  paths(PathSelectors.ant("/users/**")).
			  apis(RequestHandlerSelectors.basePackage("com.example.ExceptionHandling")).build().apiInfo(apiDetails());
	}
	private ApiInfo apiDetails() {
		return new ApiInfo("Exception Handler API","Documentation for my API","1.0","Free to use",
				new springfox.documentation.service.Contact("Saketh","", "saketh.puskuri@gmail.com"),
				"","",Collections.emptyList());
	}
}
