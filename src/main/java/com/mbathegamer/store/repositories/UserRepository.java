package com.mbathegamer.store.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mbathegamer.store.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
