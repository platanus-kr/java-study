package com.jpapractice01.byreference.order;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Orders, Long> {

//    @EntityGraph(attributePaths = {"orderItems"})
//    Optional<Orders> findById(long id);
}
