package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbathegamer.store.entities.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
  // String
  // select * from products where name = ?
  List<Product> findByName(String name);

  List<Product> findByNameLike(String name);

  List<Product> findByNameNotLike(String name);

  List<Product> findByNameContains(String name);

  List<Product> findByNameContaining(String name);

  List<Product> findByNameStartingWith(String name);

  List<Product> findByNameEndingWith(String name);

  List<Product> findByNameEndingWithIgnoreCase(String name);

  // Number
  // select * from products where price = ?
  List<Product> findByPrice(BigDecimal price);

  List<Product> findByPriceGreaterThan(BigDecimal price);

  List<Product> findByPriceGreaterThanEqual(BigDecimal price);

  List<Product> findByPriceLessThan(BigDecimal price);

  List<Product> findByPriceLessThanEqual(BigDecimal price);

  List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

  // Null
  List<Product> findByDescriptionNull();

  List<Product> findByDescriptionNotNull();

  // Multiple conditions
  List<Product> findByDescriptionNullAndNameNull();

  // Sort (OrderBy)
  List<Product> findByNameOrderByPriceDesc(String name);

  // Limit
  List<Product> findTop5ByNameOrderByPriceDesc(String name);

  List<Product> findFirst5ByNameOrderByPriceDesc(String name);
}
