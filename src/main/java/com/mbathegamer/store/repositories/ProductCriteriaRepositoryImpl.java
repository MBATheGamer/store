package com.mbathegamer.store.repositories;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mbathegamer.store.entities.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository {
  @PersistenceContext
  private final EntityManager entityManager;

  @Override
  public List<Product> findProductByCriteria(String name, BigDecimal minPrice,
      BigDecimal maxPrice) {
    CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
    CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
    Root<Product> root = criteriaQuery.from(Product.class);

    List<Predicate> predicates = new ArrayList<>();

    if (name != null) {
      // name like %?%
      predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
    }

    if (minPrice != null) {
      // price >= ?
      predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), minPrice));
    }

    if (maxPrice != null) {
      // price <= ?
      predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), maxPrice));
    }

    criteriaQuery.select(root).where(predicates.toArray(new Predicate[predicates.size()]));

    return entityManager.createQuery(criteriaQuery).getResultList();
  }
}
