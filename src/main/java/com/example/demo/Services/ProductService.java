package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Models.Product;
import com.example.demo.Repository.ProductRepo;


@Service
public class ProductService {
    @Autowired
    ProductRepo repo;
    // List<Product> products = new ArrayList<>(Arrays.asList(
    //         new Product(101, "Lg", "tv", 10000),
    //         new Product(102, "Classmate", "Book", 100),
    //         new Product(103, "Tupperware", "Bottle", 999)));

    public List<Product> getProducts() {
        System.out.println("Running");
        return repo.findAll();
    }

    public Product getProductById(Long prodId) {
        return repo.findById(prodId).orElse(new Product());
    }

    public void addProduct(Product prod) {
        repo.save(prod);
    }

    public void updateProduct(Product prod) {
        repo.save(prod);
    }

    public void deleteProduct(Product prod) {
        repo.delete(prod);
    }

    public void deleteProduct(Long prodId) {
        repo.deleteById(prodId);
    }
}
