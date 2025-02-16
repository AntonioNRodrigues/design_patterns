package com.implementations.designpatterns.factory.absctractfactory;


public class ElectronicsFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new Electronics();
    }
}

