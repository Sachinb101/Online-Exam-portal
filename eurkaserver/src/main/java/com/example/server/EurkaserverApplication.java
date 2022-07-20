package com.example.server;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurkaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurkaserverApplication.class, args);
		System.out.println("Eureka Server Strated.....");
	}

}
