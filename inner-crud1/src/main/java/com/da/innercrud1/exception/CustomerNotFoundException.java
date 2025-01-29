package com.da.innercrud1.exception;

public class CustomerNotFoundException extends RuntimeException  {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}