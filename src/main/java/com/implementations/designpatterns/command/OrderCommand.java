package com.implementations.designpatterns.command;

public class OrderCommand implements Command {

    private final OrderService orderService;
    private final String orderId;

    public OrderCommand(OrderService orderService, String orderId) {
        this.orderService = orderService;
        this.orderId = orderId;
    }

    @Override
    public void execute() {
        orderService.placeOrder(orderId);
    }
}
