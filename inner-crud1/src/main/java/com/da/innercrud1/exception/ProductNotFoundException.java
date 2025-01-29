package com.da.innercrud1.exception;

public class ProductNotFoundException extends RuntimeException  {
    public ProductNotFoundException(String message) {
        super(message);
    }
}