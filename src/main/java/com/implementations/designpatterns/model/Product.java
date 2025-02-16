package com.implementations.designpatterns.model;

public class Product {

    private final String name;
    private final double price;
    private final String category;

    private Product(ProductBuilder builder) {
        this.name = builder.name;
        this.price = builder.price;
        this.category = builder.category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public static class ProductBuilder {
        private String name;
        private double price;
        private String category;

        public ProductBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ProductBuilder setCategory(String category) {
            this.category = category;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", category=" + category + "]";
    }
}
