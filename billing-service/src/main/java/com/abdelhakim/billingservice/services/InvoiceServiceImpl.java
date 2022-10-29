package com.abdelhakim.billingservice.services;

import com.abdelhakim.billingservice.dtos.InvoiceRequestDTO;
import com.abdelhakim.billingservice.dtos.InvoiceResponseDTO;
import com.abdelhakim.billingservice.entities.Invoice;
import com.abdelhakim.billingservice.exceptions.CustomerNotFoundException;
import com.abdelhakim.billingservice.feign.CustomerRestClient;
import com.abdelhakim.billingservice.mappers.InvoiceMapper;
import com.abdelhakim.billingservice.models.Customer;
import com.abdelhakim.billingservice.repositories.InvoiceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{
    private InvoiceRepository invoiceRepository;
    private InvoiceMapper invoiceMapper;
    private CustomerRestClient customerRestClient;


    @Override
    public InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        Customer customer = null;
        try {
            customer = customerRestClient.getCustomerById(invoiceRequestDTO.getCustomerId());
        }catch (Exception e){
            throw new CustomerNotFoundException(String.format("Customer %s not found", invoiceRequestDTO.getCustomerId()));
        }

        Invoice invoice = invoiceMapper.fromInvoiceRequestDTO(invoiceRequestDTO);
        invoice.setId(UUID.randomUUID().toString());
        invoice.setDate(new Date());

        invoice.setCustomer(customer);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public InvoiceResponseDTO getInvoice(String invoiceId) {
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        Customer customer = customerRestClient.getCustomerById(invoice.getCustomerId());
        invoice.setCustomer(customer);
        return invoiceMapper.fromInvoice(invoice);
    }

    @Override
    public List<InvoiceResponseDTO> getInvoiceList() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return prepareInvoices(invoices);
    }

    @Override
    public List<InvoiceResponseDTO> getInvoiceListByCustomerId(String customerId) {
        List<Invoice> invoices = invoiceRepository.findByCustomerId(customerId);
        return prepareInvoices(invoices);
    }

    private List<InvoiceResponseDTO> prepareInvoices (List<Invoice> invoices) {
        return invoices.stream().map(invoice -> {
            Customer customer = customerRestClient.getCustomerById(invoice.getCustomerId());
            invoice.setCustomer(customer);
            return invoiceMapper.fromInvoice(invoice);
        }).collect(Collectors.toList());
    }
}
