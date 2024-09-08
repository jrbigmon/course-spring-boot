package com.jrbigmon.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrbigmon.course.entities.Category;
import com.jrbigmon.course.services.CategoryService;

@Controller
@RequestMapping(value = "/categories")
public class CategoryResource {

  @Autowired
  private CategoryService service;

  @GetMapping
  public ResponseEntity<List<Category>> findAll() {
    List<Category> results = service.findAll();

    return ResponseEntity.ok().body(results);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable String id) {
    Category category = service.findById(id);

    return ResponseEntity.ok().body(category);
  }  
}
