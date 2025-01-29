package com.da.innercrud1.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
}
