package com.jrbigmon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jrbigmon.course.entities.Product;

public interface IProductRepository extends JpaRepository<Product, String> {

}
