package com.mbathegamer.store.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("stripe")
public class StripePaymentService implements PaymentService {
  @Value("${stripe.api-url}")
  private String apiUrl;

  @Value("${stripe.enabled}")
  private boolean enabled;

  @Value("${stripe.timeout:3000}")
  private int timeout;

  @Value("${stripe.supported-currencies:}")
  private List<String> supportedCurrencies;

  @Override
  public void processPayment(double amount) {
    System.out.println("STRIPE");
    System.out.println("API URL: " + apiUrl);
    System.out.println("Enabled: " + enabled);
    System.out.println("Timeout: " + timeout);
    System.out.println("Supported currencies: " + supportedCurrencies);
    System.out.println("Amount: " + amount);
  }
}
