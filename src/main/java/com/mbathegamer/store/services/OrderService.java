package com.mbathegamer.store.services;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

// @Service
public class OrderService {
  private PaymentService paymentService;

  public OrderService() {
  }

  @Autowired
  // public OrderService(@Qualifier("stripe") PaymentService service) {
  public OrderService(PaymentService service) {
    System.out.println("OrderService created");
    this.paymentService = service;
  }

  @PostConstruct
  public void init() {
    System.out.println("OrderService PostConstruct");
  }

  @PreDestroy
  public void cleanup() {
    System.out.println("OrderService PreDestory");
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
