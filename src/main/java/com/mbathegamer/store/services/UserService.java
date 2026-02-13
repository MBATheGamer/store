package com.mbathegamer.store.services;

import java.math.BigDecimal;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

// import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.mbathegamer.store.entities.Address;
import com.mbathegamer.store.entities.Product;
// import com.mbathegamer.store.entities.Category;
// import com.mbathegamer.store.entities.Product;
import com.mbathegamer.store.entities.User;
import com.mbathegamer.store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
  // private final CategoryRepository categoryRepository;
  private final ProductRepository productRepository;
  private final AddressRepository addressRepository;
  private final UserRepository userRepository;
  private final ProfileRepository profileRepository;
  private final EntityManager entityManager;

  @Transactional
  public void showEntityStates() {
    var user = User.builder()
        .name("John Doe")
        .email("john.doe@example.com")
        .password("password")
        .build();

    if (entityManager.contains(user)) {
      System.out.println("Persistent");
    } else {
      System.out.println("Transient / Detached");
    }

    userRepository.save(user);

    if (entityManager.contains(user)) {
      System.out.println("Persistent");
    } else {
      System.out.println("Transient / Detached");
    }
  }

  @Transactional
  public void showRelatedEntities() {
    var profile = profileRepository.findById(2L).orElseThrow();
    System.out.println(profile.getUser().getEmail());
  }

  public void fetchAddress() {
    addressRepository.findById(1L).orElseThrow();
  }

  public void persistRelated() {
    var user = User.builder()
        .name("John Doe")
        .email("john.doe@example.com")
        .password("password")
        .build();

    var address = Address.builder()
        .street("street")
        .city("city")
        .state("state")
        .zip("zip")
        .build();

    user.addAddress(address);

    userRepository.save(user);
  }

  @Transactional
  public void deleteRelated() {
    // userRepository.deleteById(1L);

    var user = userRepository.findById(1L).orElseThrow();
    var address = user.getAddresses().getFirst();

    user.removeAddress(address);
    userRepository.save(user);
  }

  @Transactional
  public void manageProducts() {
    // Step 1
    // var category = Category.builder()
    // .name("category1")
    // .build();

    // var product = Product.builder()
    // .name("product1")
    // .description("description")
    // .price(BigDecimal.valueOf(1.99))
    // .category(category)
    // .build();

    // productRepository.save(product);

    // Step 2
    // var category = categoryRepository.findById((byte) 1).orElseThrow();

    // var product = Product.builder()
    // .name("product1")
    // .description("description")
    // .price(BigDecimal.valueOf(1.99))
    // .category(category)
    // .build();

    // productRepository.save(product);

    // Step 3
    // var user = userRepository.findById(1L).orElseThrow();
    // var products = productRepository.findAll();

    // products.forEach(user::addToWishlist);

    // userRepository.save(user);

    // Step 4
    productRepository.deleteById(2L);
  }

  @Transactional
  public void updateProductPrice() {
    productRepository.updatePriceByCategory(BigDecimal.valueOf(9.99), (byte) 1);
  }

  @Transactional
  public void fetchProducts() {
    // var products = productRepository.findByCategory(new Category((byte) 1));
    // var products = productRepository
    // .findByProducts(BigDecimal.valueOf(1), BigDecimal.valueOf(9.99));

    // products.forEach(System.out::println);

    var product = new Product();
    product.setName("product");

    var matcher = ExampleMatcher.matching()
        .withIncludeNullValues()
        .withIgnorePaths("id", "description")
        .withStringMatcher(StringMatcher.STARTING);

    var example = Example.of(product, matcher);
    var products = productRepository.findAll(example);

    products.forEach(System.out::println);
  }

  public void fetchProductByCriteria() {
    var products = productRepository
        .findProductByCriteria("product", BigDecimal.valueOf(1), BigDecimal.valueOf(9.99));

    products.forEach(System.out::println);
  }

  @Transactional
  public void fetchUser() {
    var user = userRepository.findByEmail("john.doe@example.com").orElseThrow();

    // System.out.println(user.getId());
    System.out.println(user);
  }

  @Transactional
  public void fetchUsers() {
    var users = userRepository.findAllWithAddresses();

    users.forEach(user -> {
      System.out.println(user);
      user.getAddresses().forEach(System.out::println);
    });
  }

  @Transactional
  public void printLoyalProfiles() {
    // var profiles = profileRepository.findLoyaltyPoints(2);
    var users = userRepository.findLoyalUsers(2);

    users.forEach(user -> {
      System.out.println(user.getId() + ": " + user.getEmail());
    });
  }
}
