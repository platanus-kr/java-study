package com.jpapractice01.byreference.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceRef {
    private final OrderRepositoryRef orderRepositoryRef;

    @Transactional
    public void save(OrdersRef order) {
        orderRepositoryRef.save(order);
    }

    public OrdersRef findById(long id) {
        return orderRepositoryRef.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
