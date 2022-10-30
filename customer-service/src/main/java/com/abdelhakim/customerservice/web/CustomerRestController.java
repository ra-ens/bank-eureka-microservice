package com.abdelhakim.customerservice.web;

import com.abdelhakim.customerservice.dto.CustomerRequestDTO;
import com.abdelhakim.customerservice.dto.CustomerResponseDTO;
import com.abdelhakim.customerservice.entities.Customer;
import com.abdelhakim.customerservice.services.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
@Slf4j
public class CustomerRestController {
    private CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping(path = "/customers")
    public List<CustomerResponseDTO> customers(){
        log.info("****************************");
        log.info(Thread.currentThread().getName());
        log.info("****************************");
        return customerService.getCustomers();
    }
    @GetMapping(path = "/customers/{id}")
    public CustomerResponseDTO customerById(@PathVariable String id){
        return customerService.getCustomer(id);
    }

    @PostMapping(path = "/customers")
    public CustomerResponseDTO save(@RequestBody CustomerRequestDTO customerRequestDTO){

        log.info("****************************");
        log.info(Thread.currentThread().getName());
        log.info("****************************");
        customerRequestDTO.setId(UUID.randomUUID().toString());
        return customerService.save(customerRequestDTO);
    }

    @PutMapping(path = "/customers/{id}")
    public CustomerResponseDTO update(@RequestBody CustomerRequestDTO customerRequestDTO, @PathVariable String id){
        customerRequestDTO.setId(id);
        return customerService.save(customerRequestDTO);
    }
    @DeleteMapping(path = "/customers/{id}")
    public void delete(@PathVariable String id){
        customerService.deleteCustomer(id);
    }
}
