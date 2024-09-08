package com.jrbigmon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrbigmon.course.entities.Category;

public interface ICategoryRepository extends JpaRepository<Category, String> {

}
