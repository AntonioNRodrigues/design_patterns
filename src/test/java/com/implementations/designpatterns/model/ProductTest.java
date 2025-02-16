package com.implementations.designpatterns.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void productBuilderCreatesProductWithValidData() {
        Product product = new Product.ProductBuilder()
                .setName("Laptop")
                .setPrice(999.99)
                .setCategory("Electronics")
                .build();
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice());
        assertEquals("Electronics", product.getCategory());
    }

    @Test
    void productBuilderCreatesProductWithEmptyName() {
        Product product = new Product.ProductBuilder()
                .setName("")
                .setPrice(999.99)
                .setCategory("Electronics")
                .build();
        assertEquals("", product.getName());
        assertEquals(999.99, product.getPrice());
        assertEquals("Electronics", product.getCategory());
    }

    @Test
    void productBuilderCreatesProductWithZeroPrice() {
        Product product = new Product.ProductBuilder()
                .setName("Laptop")
                .setPrice(0.0)
                .setCategory("Electronics")
                .build();
        assertEquals("Laptop", product.getName());
        assertEquals(0.0, product.getPrice());
        assertEquals("Electronics", product.getCategory());
    }

    @Test
    void productBuilderCreatesProductWithNegativePrice() {
        Product product = new Product.ProductBuilder()
                .setName("Laptop")
                .setPrice(-100.0)
                .setCategory("Electronics")
                .build();
        assertEquals("Laptop", product.getName());
        assertEquals(-100.0, product.getPrice());
        assertEquals("Electronics", product.getCategory());
    }

    @Test
    void productBuilderCreatesProductWithNullCategory() {
        Product product = new Product.ProductBuilder()
                .setName("Laptop")
                .setPrice(999.99)
                .setCategory(null)
                .build();
        assertEquals("Laptop", product.getName());
        assertEquals(999.99, product.getPrice());
        assertNull(product.getCategory());
    }
}