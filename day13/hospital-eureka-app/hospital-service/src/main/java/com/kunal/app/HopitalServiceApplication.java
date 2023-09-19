package com.kunal.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HopitalServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HopitalServiceApplication.class, args);
	}

}
