package com.abdelhakim.billingservice.dtos;

import com.abdelhakim.billingservice.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceResponseDTO {
    private String id;
    private Date date;
    private Double amount;
    private Customer customer;
}
