package com.mbathegamer.store.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
  private PaymentService paymentService;

  public OrderService() {
  }

  @Autowired
  public OrderService(@Qualifier("stripe") PaymentService service) {
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
