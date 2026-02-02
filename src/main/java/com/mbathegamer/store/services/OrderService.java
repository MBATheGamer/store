package com.mbathegamer.store.services;

public class OrderService {
  private PaymentService paymentService;

  public OrderService(PaymentService service) {
    this.paymentService = service;
  }

  public void setPaymentService(PaymentService paymentService) {
    this.paymentService = paymentService;
  }

  public void placeOrder() {
    if (paymentService == null) {
      System.out.println("You must set a payment service before using this method");
      return;
    }

    paymentService.processPayment(10);
  }
}
