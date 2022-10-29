package com.abdelhakim.billingservice.services;

import com.abdelhakim.billingservice.dtos.InvoiceRequestDTO;
import com.abdelhakim.billingservice.dtos.InvoiceResponseDTO;
import com.abdelhakim.billingservice.exceptions.CustomerNotFoundException;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException;
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> getInvoiceList();
    List<InvoiceResponseDTO> getInvoiceListByCustomerId(String customerId);
}