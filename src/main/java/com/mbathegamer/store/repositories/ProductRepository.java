package com.mbathegamer.store.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

// import com.mbathegamer.store.dtos.ProductSummary;
import com.mbathegamer.store.dtos.ProductSummaryDTO;
import com.mbathegamer.store.entities.Category;
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

  // Find products whose prices are in a given range and sort by name
  // SQL
  // @Query(value = "select * from products p where p.price between :min and :max
  // order by p.name", nativeQuery = true)
  // JPQL
  // @Query(
  // "select p from Product p join p.category where p.price between :min and :max order by p.name"
  // )
  // List<Product> findByProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);
  @Procedure("findProductByPrice")
  List<Product> findByProducts(BigDecimal min, BigDecimal max);

  @Query("select count(*) from Product p where p.price between :min and :max")
  long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

  @Modifying
  @Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
  void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

  // List<ProductSummary> findByCategory(Category category);
  // List<ProductSummaryDTO> findByCategory(Category category);

  // @Query("select p.id, p.name from Product p where p.category = :category")
  // List<ProductSummary> findByCategory(Category category);

  @Query("select  new com.mbathegamer.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category = :category")
  List<ProductSummaryDTO> findByCategory(Category category);
}
