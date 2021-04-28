package com.cognizant.BankManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gcp.data.datastore.repository.config.EnableDatastoreRepositories;


@SpringBootApplication
@EnableDatastoreRepositories
public class RegistrationLoginServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationLoginServiceApplication.class, args);
	}

}
