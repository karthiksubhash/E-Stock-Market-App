package com.estockcompanyinfoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CompanyInfoServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompanyInfoServicesApplication.class, args);
	}

}
