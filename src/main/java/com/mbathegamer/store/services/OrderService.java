package com.mbathegamer.store.services;

public class OrderService {
  private PaymentService paymentService;

  public OrderService(PaymentService service) {
    this.paymentService = service;
  }

  public void placeOrder() {
    paymentService.processPayment(10);
  }
}
