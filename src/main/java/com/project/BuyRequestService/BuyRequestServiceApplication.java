package com.project.BuyRequestService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class BuyRequestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyRequestServiceApplication.class, args);
	}

}
