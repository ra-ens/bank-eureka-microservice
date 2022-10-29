package com.abdelhakim.billingservice;

import com.abdelhakim.billingservice.dtos.InvoiceRequestDTO;
import com.abdelhakim.billingservice.exceptions.CustomerNotFoundException;
import com.abdelhakim.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InvoiceService invoiceService) {
		return args -> {
			try {
				invoiceService.save(new InvoiceRequestDTO(Double.valueOf(527550),"001"));
				invoiceService.save(new InvoiceRequestDTO(Double.valueOf(200000),"001"));
				invoiceService.save(new InvoiceRequestDTO(Double.valueOf(550),"002"));
			} catch (CustomerNotFoundException e) {
				throw new RuntimeException(e);
			}
		};
	}

}
