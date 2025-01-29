package com.da.innercrud1.exception;

public class OrderNotFoundException extends RuntimeException  {
    public OrderNotFoundException(String message) {
        super(message);
    }
}