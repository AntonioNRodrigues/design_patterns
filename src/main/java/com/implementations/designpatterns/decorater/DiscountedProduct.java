package com.implementations.designpatterns.decorater;

public class DiscountedProduct extends ProductDecorator {
    public DiscountedProduct(Product decoratedProduct) {
        super(decoratedProduct);
    }

    @Override
    public double getPrice() {
        return decoratedProduct.getPrice() * 0.9;
    }
}
