package com.jrbigmon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrbigmon.course.entities.Order;

public interface IOrderRepository extends JpaRepository<Order, String> {

}
