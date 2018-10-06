package com.hisrun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HisrunServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HisrunServerApplication.class, args);
	}
}
