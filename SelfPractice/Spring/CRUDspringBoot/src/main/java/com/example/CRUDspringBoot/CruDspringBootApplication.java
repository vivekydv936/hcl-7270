package com.example.CRUDspringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication()
public class CruDspringBootApplication {

	public static void main(String[] args) {

		SpringApplication.run(CruDspringBootApplication.class, args);
		System.out.println("hello welcome");
	}

}
