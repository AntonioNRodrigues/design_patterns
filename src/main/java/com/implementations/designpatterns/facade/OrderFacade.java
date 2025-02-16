package com.implementations.designpatterns.facade;

public class OrderFacade {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final ShippingService shippingService;

    public OrderFacade() {
        this.inventoryService = new InventoryService();
        this.paymentService = new PaymentService();
        this.shippingService = new ShippingService();
    }

    public void placeOrder(String productId, double amount) {
        if (inventoryService.checkStock(productId)) {
            paymentService.processPayment(amount);
            shippingService.shipProduct(productId);
        }
    }
}
