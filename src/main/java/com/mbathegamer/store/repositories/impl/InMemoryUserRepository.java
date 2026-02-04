package com.mbathegamer.store.repositories.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mbathegamer.store.models.User;
import com.mbathegamer.store.repositories.UserRepository;

@Repository
public class InMemoryUserRepository implements UserRepository {
  private final Map<String, User> users = new HashMap<>();

  @Override
  public void save(User user) {
    System.out.println("Saving user: " + user);
    users.put(user.getEmail(), user);
  }

  @Override
  public User findUserByEmail(String email) {
    return users.getOrDefault(email, null);
  }

  @Override
  public String toString() {
    return "InMemoryUserRepository [users=" + users + "]";
  }
}
