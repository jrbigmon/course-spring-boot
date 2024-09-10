package com.jrbigmon.course.entities;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
  public static final long serialVersionUID = 1L;

  @Id
  private String id;

  @Column
  private String name;

  @Transient
  private Set<Product> products = new HashSet<>();

  public Category() {
  }

  public Category(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public Category(String name) {
    this.id = UUID.randomUUID().toString();
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Set<Product> getProducts() {
    return products;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Category other = (Category) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }
}
