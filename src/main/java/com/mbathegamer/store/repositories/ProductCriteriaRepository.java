package com.mbathegamer.store.repositories;

import java.math.BigDecimal;
import java.util.List;

import com.mbathegamer.store.entities.Product;

public interface ProductCriteriaRepository {
  List<Product> findProductByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
