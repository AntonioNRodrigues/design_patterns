package com.implementations.designpatterns.model;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct {

    private final List<Product> products;

    public CompositeProduct() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}
