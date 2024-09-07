package com.jrbigmon.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jrbigmon.course.entities.Order;
import com.jrbigmon.course.services.OrderService;

@Controller
@RequestMapping(value = "/orders")
public class OrderResource {

  @Autowired
  private OrderService service;

  @GetMapping
  public ResponseEntity<List<Order>> findAll() {
    List<Order> results = service.findAll();

    return ResponseEntity.ok().body(results);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> findById(@PathVariable String id) {
    Order order = service.findById(id);

    return ResponseEntity.ok().body(order);
  }  
}
