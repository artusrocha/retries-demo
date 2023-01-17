package com.example.retries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RetiresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetiresApplication.class, args);
	}

}
