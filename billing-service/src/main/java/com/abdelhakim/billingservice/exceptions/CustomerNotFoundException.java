package com.abdelhakim.billingservice.exceptions;

public class CustomerNotFoundException extends Throwable {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}