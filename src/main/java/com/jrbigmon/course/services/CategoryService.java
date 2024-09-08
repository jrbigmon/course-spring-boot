package com.jrbigmon.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrbigmon.course.entities.Category;
import com.jrbigmon.course.repositories.ICategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  @Autowired
  private ICategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category findById(String id) {
    Optional<Category> optional = categoryRepository.findById(id);

    return optional.get();
  }
}
