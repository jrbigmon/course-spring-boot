package com.jrbigmon.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrbigmon.course.entities.Order;
import com.jrbigmon.course.repositories.IOrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

  @Autowired
  private IOrderRepository orderRepository;

  public List<Order> findAll() {
    return orderRepository.findAll();
  }

  public Order findById(String id) {
    Optional<Order> optional = orderRepository.findById(id);

    return optional.get();
  }
}
