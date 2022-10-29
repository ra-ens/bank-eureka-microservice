package com.abdelhakim.billingservice.mappers;

import com.abdelhakim.billingservice.dtos.InvoiceRequestDTO;
import com.abdelhakim.billingservice.dtos.InvoiceResponseDTO;
import com.abdelhakim.billingservice.entities.Invoice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    Invoice fromInvoiceRequestDTO(InvoiceRequestDTO invoiceRequestDTO);
    InvoiceResponseDTO fromInvoice(Invoice invoice);
}