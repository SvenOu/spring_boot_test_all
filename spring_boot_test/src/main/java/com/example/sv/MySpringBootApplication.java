package com.example.sv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.DispatcherServletAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication
//@Configuration
//@EnableAutoConfiguration(exclude = {DispatcherServletAutoConfiguration.class})
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.sv"},
		// To avoid config conflict
		excludeFilters={@ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = {
				"com.example.sv.mobile.configs.*",
				"com.example.sv.mobile.controller.*",
				"com.example.sv.web.configs.*",
				"com.example.sv.web.controller.*"
		})}
)
public class MySpringBootApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MySpringBootApplication.class);
	}
}
