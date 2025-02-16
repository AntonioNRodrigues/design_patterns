package com.implementations.designpatterns.factory.absctractfactory;

public class FurnitureFactory implements ProductFactory {

    @Override
    public Product createProduct() {
        return new Furniture();
    }
}
