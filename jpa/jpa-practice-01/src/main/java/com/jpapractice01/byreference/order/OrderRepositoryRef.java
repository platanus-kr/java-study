package com.jpapractice01.byreference.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryRef extends JpaRepository<OrdersRef, Long> {
}
