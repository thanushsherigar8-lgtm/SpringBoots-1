package com.example.demo.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int prodId;
    private String prodName;
    private String prodType;
    private int price;
}
