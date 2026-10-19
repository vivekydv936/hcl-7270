package com.example.SBootApplicationProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SBootApplicationPropertiesApplication {

	public static void main(String[] args) {

	ApplicationContext contxt = SpringApplication.run(SBootApplicationPropertiesApplication.class, args);


//		PaymentGateway paymentGateway =contxt.getBean(PaymentGateway.class);

//		payment.setRetryCount(12);
//		payment.setType("vivek");

//		System.out.println(paymentGateway.getType());
//		System.out.println(paymentGateway.getRetryCount());



	}

}
