package com.implementations.designpatterns.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompositeProductTest {

    @Test
    void addProductIncreasesProductListSize() {
        CompositeProduct compositeProduct = new CompositeProduct();
        Product product = new Product.ProductBuilder().setName("Laptop").setPrice(999.99).setCategory("Electronics").build();
        compositeProduct.addProduct(product);
        assertEquals(1, compositeProduct.getProducts().size());
    }

    @Test
    void removeProductDecreasesProductListSize() {
        CompositeProduct compositeProduct = new CompositeProduct();
        Product product = new Product.ProductBuilder().setName("Laptop").setPrice(999.99).setCategory("Electronics").build();
        compositeProduct.addProduct(product);
        compositeProduct.removeProduct(product);
        assertEquals(0, compositeProduct.getProducts().size());
    }

    @Test
    void addMultipleProductsIncreasesProductListSize() {
        CompositeProduct compositeProduct = new CompositeProduct();
        Product product1 = new Product.ProductBuilder().setName("Laptop").setPrice(999.99).setCategory("Electronics").build();
        Product product2 = new Product.ProductBuilder().setName("Phone").setPrice(499.99).setCategory("Electronics").build();
        compositeProduct.addProduct(product1);
        compositeProduct.addProduct(product2);
        assertEquals(2, compositeProduct.getProducts().size());
    }

    @Test
    void removeProductNotInListDoesNotChangeProductListSize() {
        CompositeProduct compositeProduct = new CompositeProduct();
        Product product1 = new Product.ProductBuilder().setName("Laptop").setPrice(999.99).setCategory("Electronics").build();
        Product product2 = new Product.ProductBuilder().setName("Phone").setPrice(499.99).setCategory("Electronics").build();
        compositeProduct.addProduct(product1);
        compositeProduct.removeProduct(product2);
        assertEquals(1, compositeProduct.getProducts().size());
    }

}