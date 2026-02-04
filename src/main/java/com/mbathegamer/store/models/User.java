package com.mbathegamer.store.models;

public class User {
  private Long id;
  private String email;
  private String password;
  private String name;

  public User(Long id, String email, String password, String name) {
    this.id = id;
    this.email = email;
    this.password = password;
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "User [id=" + id + ", email=" + email + ", name=" + name + "]";
  }
}
