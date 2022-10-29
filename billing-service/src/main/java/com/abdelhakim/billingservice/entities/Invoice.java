package com.abdelhakim.billingservice.entities;

import com.abdelhakim.billingservice.models.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Invoice {
    @Id
    private String id;
    private Date date;
    private Double amount;
    private String customerId;
    @Transient
    private Customer customer;
}
