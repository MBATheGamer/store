package com.mbathegamer.store.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @OneToOne(mappedBy = "user")
  private Profile profile;

  @Builder.Default
  @OneToMany(mappedBy = "user")
  private List<Address> addresses = new ArrayList<>();

  @ManyToMany
  @Builder.Default
  @JoinTable(name = "user_tags", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
  private Set<Tag> tags = new HashSet<>();

  @ManyToMany
  @Builder.Default
  @JoinTable(name = "wishlist", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
  private Set<Product> wishlist = new HashSet<>();

  public void addProfile(Profile profile) {
    this.profile = profile;
    profile.setUser(this);
  }

  public void removeProfile(Profile profile) {
    this.profile = null;
    profile.setUser(null);
  }

  public void addAddress(Address address) {
    addresses.add(address);
    address.setUser(this);
  }

  public void removeAddress(Address address) {
    addresses.remove(address);
    address.setUser(null);
  }

  public void addTag(String tagName) {
    var tag = new Tag(tagName);
    tags.add(tag);
    tag.getUsers().add(this);
  }

  public void removeTag(String tagName) {
    tags.removeIf(tag -> {
      if (tag.getName().equals(tagName)) {
        tag.getUsers().remove(this);
        return true;
      }

      return false;
    });
  }
}
