package com.example.demo.Services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.Models.Product;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101, "Lg", "tv", 10000),
            new Product(102, "Classmate", "Book", 100),
            new Product(103, "Tupperware", "Bottle", 999)));

    public List<Product> getProducts() {
        System.out.println("Running");
        return products;
    }

    public Product getProductById(int prodId) {
        Product pod;
        try{
        pod= products.stream().filter(p -> p.getProdId() == prodId).findFirst().orElse(new Product(100,"No-Item","",0));
        }catch(NoSuchElementException e){
            System.out.println("Not found in records");
            return null;
        }
        return pod;
    }
    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProdId()==prod.getProdId()){
                products.set(i,prod);
                return;
            }
        }    
    }

    public void deleteProduct(Product prod) {
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProdId()==prod.getProdId()){
                products.remove(i);
                return;
            }
        }  
    }
}
