package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbathegamer.store.entities.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
