package com.mbathegamer.store.repositories;

import com.mbathegamer.store.models.User;

public interface UserRepository {
  void save(User user);

  User findUserByEmail(String email);
}
