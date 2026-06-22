package com.example.demo.Models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
@Data
@AllArgsConstructor
@ToString
@Entity
@Component
public class Product {
    @Id
    private Integer prodId;
    private String prodName;
    private String prodType;
    private int price;
    public Product(){

    }
}

