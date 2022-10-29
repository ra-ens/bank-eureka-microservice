package com.abdelhakim.billingservice.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class InvoiceRequestDTO {
    private Double amount;
    private String customerId;
}
