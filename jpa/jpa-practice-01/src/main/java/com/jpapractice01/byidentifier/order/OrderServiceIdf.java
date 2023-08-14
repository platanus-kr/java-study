package com.jpapractice01.byidentifier.order;

import com.jpapractice01.byidentifier.delivery.DeliveryIdf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceIdf {
    private final OrderRepositoryIdf orderRepositoryIdf;

    @Transactional
    public void save(OrdersIdf order) {
        orderRepositoryIdf.save(order);
    }

    public OrdersIdf findById(long id) {
        return orderRepositoryIdf.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

}
