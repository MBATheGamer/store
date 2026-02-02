package com.mbathegamer.store.services;

public class PayPalPaymentService implements PaymentService {
  @Override
  public void processPayment(double amount) {
    System.out.println("PAYPAL");
    System.out.println("Amount: " + amount);
  }
}
