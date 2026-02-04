package com.mbathegamer.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

// import com.mbathegamer.store.components.HeavyResource;
import com.mbathegamer.store.services.OrderService;

@SpringBootApplication
public class StoreApplication {
	public static void main(String[] args) {
		// SpringApplication.run(StoreApplication.class, args);

		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		// context.getBean(HeavyResource.class);

		var orderService = context.getBean(OrderService.class);
		context.getBean(OrderService.class);

		orderService.placeOrder();

		context.close();

		// var manager = context.getBean(NotificationManager.class);
		// manager.sendNotification("This is a test");
	}
}
