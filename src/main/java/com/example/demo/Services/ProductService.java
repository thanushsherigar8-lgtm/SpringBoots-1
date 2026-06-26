package com.example.demo.Services;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    public Product addProduct(Product prod) {
        return repo.save(prod);
    }
    public Product addProduct(Product prod, MultipartFile imageFile) throws IOException {
        try{prod.setImageName(imageFile.getOriginalFilename() != null ? imageFile.getOriginalFilename() : "uploaded-image");
        prod.setImageData(imageFile.getBytes());
        return repo.save(prod);
        } catch (IOException e) {
            throw new IOException("Error occurred while processing the image file", e);
        }
    }

    public Product updateProduct(Product prod) {
        return repo.save(prod);
    }

    public void deleteProduct(Product prod) {
        repo.delete(prod);
    }

    public void deleteProduct(Long prodId) {
        repo.deleteById(prodId);
    }
}
