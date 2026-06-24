package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Models.Product;
import com.example.demo.Services.ProductService;

@RestController
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/Product")
    public List<Product> getProductService() {
        return service.getProducts();
    }

    @GetMapping("/Product/{prodId}")
    public Product getProduct(@PathVariable Long prodId) {
        return service.getProductById(prodId);
    }
    @PostMapping("/Product")
    public void addProduct(@RequestBody Product prod){
        System.out.println(prod.toString());
        try{
            service.addProduct(prod);
            }
            catch(Exception e){
                System.out.println(e);
            }
    }
    @PutMapping("/Product")
    public void updateProduct(@RequestBody Product prod){
        service.updateProduct(prod);
    }
    @DeleteMapping("/Product")
    public void deleteProduct(@RequestBody Product prod){
        service.deleteProduct(prod);
    }
    @DeleteMapping("/Product/{prodId}")
    public void deleteProduct(@PathVariable Long prodId){
        service.deleteProduct(prodId);
    }
    @GetMapping("/ProductExample")
    public Product getProductExample() {
        return new Product(1, "Product 1", "Type 1", "Description 1", "Category 1", new java.util.Date(), 100L, 10, true);
    }
}
