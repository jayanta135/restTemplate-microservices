package com.clientstudentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ClientStudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientStudentServiceApplication.class, args);
	}

}
