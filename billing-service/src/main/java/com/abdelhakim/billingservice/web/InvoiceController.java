package com.abdelhakim.billingservice.web;

import com.abdelhakim.billingservice.dtos.InvoiceRequestDTO;
import com.abdelhakim.billingservice.dtos.InvoiceResponseDTO;
import com.abdelhakim.billingservice.exceptions.CustomerNotFoundException;
import com.abdelhakim.billingservice.services.InvoiceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
public class InvoiceController {
    private InvoiceService invoiceService;

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){
        return invoiceService.getInvoice(id);
    }

    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> getInvoiceList(){
        return invoiceService.getInvoiceList();
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoiceListByCustomerId(@PathVariable String customerId){
        return invoiceService.getInvoiceListByCustomerId(customerId);
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        return invoiceService.save(invoiceRequestDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}