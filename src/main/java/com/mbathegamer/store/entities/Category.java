package com.mbathegamer.store.entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "categories")
public class Category {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Byte id;

  @Column(name = "name")
  private String name;

  @Builder.Default
  @OneToMany(mappedBy = "category")
  private Set<Product> products = new HashSet<>();

  public void addProduct(Product product) {
    products.add(product);
    product.setCategory(this);
  }

  public void removeProduct(Product product) {
    products.remove(product);
    product.setCategory(null);
  }
}
