package com.jpapractice01.byidentifier.delivery;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepositoryIdf extends JpaRepository<DeliveryIdf, Long> {
    Optional<List<DeliveryIdf>> findAllByOrdersNo(long ordersNo);
}
