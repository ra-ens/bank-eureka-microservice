package com.abdelhakim.customerservice;

import com.abdelhakim.customerservice.dto.CustomerRequestDTO;
import com.abdelhakim.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.save(new CustomerRequestDTO("100","Mohammed","mohamed@gmail.com"));
			customerService.save(new CustomerRequestDTO("200","Abdelhakim","abdelhakim@gmail.com"));
		};
	}
}
