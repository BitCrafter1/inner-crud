package com.da.innercrud1.model;

import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name= "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String description;
    private double price;
}
