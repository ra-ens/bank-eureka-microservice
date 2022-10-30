package com.abdelhakim.customerservice.services;

import com.abdelhakim.customerservice.dto.CustomerRequestDTO;
import com.abdelhakim.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO getCustomer(String id);
    List<CustomerResponseDTO> getCustomers();
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(String id);
}
