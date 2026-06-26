package com.example.demo.Models;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@Entity
@Component
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer prodId;
    private String prodName;
    private String prodType;
    private String prodDesc;
    @JsonProperty("Category")
    @JsonAlias({"category", "cat"})
    private String Category;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Date prodDate;
    private Long price;
    private Integer quantity;
    private boolean availability;
    private String imageName;
    @Lob
    @Column(name = "image_data")
    private byte[] imageData;

    public Product() {
    }

    @PrePersist
    protected void onCreate() {
        if (this.prodDate == null) {
            this.prodDate = new Date();
        }
    }
}

