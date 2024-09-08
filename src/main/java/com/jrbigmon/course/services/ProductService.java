package com.jrbigmon.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrbigmon.course.entities.Product;
import com.jrbigmon.course.repositories.IProductRepository;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

  @Autowired
  private IProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }

  public Product findById(String id) {
    Optional<Product> optional = productRepository.findById(id);

    return optional.get();
  }
}
