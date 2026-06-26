package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.Models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

class ProductSerializationTest {

    @Test
    void shouldDeserializeCategoryFieldFromJson() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        String json = "{\"prodName\":\"Test Product\",\"prodType\":\"Type\",\"prodDesc\":\"Desc\",\"Category\":\"Books\",\"price\":1000,\"quantity\":4,\"availability\":true}";

        Product product = mapper.readValue(json, Product.class);

        assertEquals("Books", product.getCategory());
    }
}
