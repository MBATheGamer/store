package com.mbathegamer.store.repositories.specifications;

import java.math.BigDecimal;

import org.springframework.data.jpa.domain.Specification;

import com.mbathegamer.store.entities.Product;

public class ProductSpec {
  public static Specification<Product> hasName(String name) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"),
        "%" + name + "%");
  }

  public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal price) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"),
        price);
  }

  public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal price) {
    return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"),
        price);
  }
}
