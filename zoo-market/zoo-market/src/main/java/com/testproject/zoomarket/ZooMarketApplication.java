package com.testproject.zoomarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ZooMarketApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZooMarketApplication.class, args);
	}

}
