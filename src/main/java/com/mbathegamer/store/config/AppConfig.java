package com.mbathegamer.store.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mbathegamer.store.services.OrderService;
import com.mbathegamer.store.services.PaymentService;
import com.mbathegamer.store.services.StripePaymentService;

@Configuration
public class AppConfig {
  @Value("${payment-gateway:stripe}")
  private String paymentGateway;

  @Bean
  PaymentService stripe() {
    return new StripePaymentService();
  }

  @Bean
  PaymentService paypal() {
    return new StripePaymentService();
  }

  @Bean
  OrderService orderService() {
    if (paymentGateway.equals("stripe")) {
      return new OrderService(stripe());
    }

    return new OrderService(paypal());
  }
}
