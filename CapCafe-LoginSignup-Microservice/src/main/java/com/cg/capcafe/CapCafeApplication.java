package com.cg.capcafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CapCafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapCafeApplication.class, args);
	}

}
