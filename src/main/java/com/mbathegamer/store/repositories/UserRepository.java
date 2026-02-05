package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbathegamer.store.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
