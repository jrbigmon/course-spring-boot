package com.jrbigmon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jrbigmon.course.entities.Payment;

public interface IPaymentRepository extends JpaRepository<Payment, String> {

}
