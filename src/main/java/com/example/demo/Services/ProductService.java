package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Models.Product;
@Service
public class ProductService {
    public List<Product> getProducts(){
        System.out.println("Running");
        List<Product> products=Arrays.asList(new Product(101,"Lg","tv",10000),new Product(102,"Classmate","Book",100),new Product(103,"Tupperware","Bottle",999));
        return products;
    }
}
