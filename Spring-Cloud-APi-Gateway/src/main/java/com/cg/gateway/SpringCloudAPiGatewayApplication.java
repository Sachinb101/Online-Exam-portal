package com.cg.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class SpringCloudAPiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudAPiGatewayApplication.class, args);
	}

}
