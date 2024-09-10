package com.jrbigmon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrbigmon.course.entities.OrderItem;
import com.jrbigmon.course.entities.OrderItemPK;

public interface IOrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
