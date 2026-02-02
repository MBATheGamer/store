package com.mbathegamer.store;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mbathegamer.store.services.OrderService;
import com.mbathegamer.store.services.StripePaymentService;

@SpringBootApplication
public class StoreApplication {
	public static void main(String[] args) {
		// SpringApplication.run(StoreApplication.class, args);

		var orderService = new OrderService(new StripePaymentService());

		orderService.placeOrder();
	}
}
