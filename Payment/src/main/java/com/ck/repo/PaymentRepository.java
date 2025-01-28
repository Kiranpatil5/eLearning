package com.ck.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ck.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
