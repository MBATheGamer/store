package com.mbathegamer.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mbathegamer.store.services.UserService;

@SpringBootApplication
public class StoreApplication {
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var service = context.getBean(UserService.class);
		// service.showEntityStates();
		// service.showRelatedEntities();
		// service.fetchAddress();
		// service.persistRelated();
		// service.deleteRelated();
		// service.manageProducts();
		// service.updateProductPrice();
		// service.fetchProducts();
		// service.fetchProductByCriteria();
		// service.fetchProductsBySpecifications("prod", null, null);
		// service.fetchUser();
		// service.printLoyalProfiles();
		service.fetchSortedProducts();
		service.fetchPaginatedProduct(0, 20);
	}
}
