package com.mbathegamer.store.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbathegamer.store.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
  @EntityGraph(attributePaths = { "tags", "addresses" })
  Optional<User> findByEmail(String email);

  @EntityGraph(attributePaths = "addresses")
  @Query("select u from User u")
  List<User> findAllWithAddresses();
}
