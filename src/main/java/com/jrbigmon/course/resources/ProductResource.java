package com.jrbigmon.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrbigmon.course.entities.Product;
import com.jrbigmon.course.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {

  @Autowired
  private ProductService service;

  @GetMapping
  public ResponseEntity<List<Product>> findAll() {

    List<Product> results = this.service.findAll();

    return ResponseEntity.ok().body(results);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Product> findById(@PathVariable String id) {
    Product product = this.service.findById(id);

    return ResponseEntity.ok().body(product);
  }
}
