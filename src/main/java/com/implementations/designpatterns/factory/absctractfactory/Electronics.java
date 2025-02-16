package com.implementations.designpatterns.factory.absctractfactory;


public class Electronics implements Product {
    private final String description;
    private final double price;

    public Electronics() {
        this.description = "Default Electronics";
        this.price = 100.0;
    }

    public Electronics(String description, double price) {
        this.description = description;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Electronics [description=" + description + ", price=" + price + "]";
    }
}
