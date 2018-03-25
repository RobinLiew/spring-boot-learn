package com.robinliew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @author RobinLiew
 *
 */
//@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class ContactApplication {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(ContactApplication.class, args);
	}

}
