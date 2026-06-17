package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Models.Product;
import com.example.demo.Services.ProductService;

@RestController
public class ProductController {
    @Autowired
    ProductService service;
    @RequestMapping("/getProduct")
    public List<Product> getProductService(){
        return service.getProducts();

    }
}
