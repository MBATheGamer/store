package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbathegamer.store.entities.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
