package com.springmvc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages={"com.springmvc.demo"})
@EntityScan(basePackages={"com.springmvc.demo.bo"})
@EnableJpaRepositories(basePackages={"com.springmvc.demo.bo"})
public class DemoApplication extends SpringBootServletInitializer  {

	 @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	 	   return application.sources(DemoApplication.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
