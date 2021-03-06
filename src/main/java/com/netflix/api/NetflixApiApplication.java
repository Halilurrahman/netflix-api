package com.netflix.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NetflixApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixApiApplication.class, args);
	}
}
