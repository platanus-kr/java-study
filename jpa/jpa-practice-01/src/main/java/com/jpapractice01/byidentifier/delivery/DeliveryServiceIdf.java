package com.jpapractice01.byidentifier.delivery;


import com.jpapractice01.byidentifier.order.OrderRepositoryIdf;
import com.jpapractice01.byidentifier.order.OrderServiceIdf;
import com.jpapractice01.byidentifier.order.OrdersIdf;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceIdf {
    private final DeliveryRepositoryIdf deliveryRepositoryIdf;

    private final OrderRepositoryIdf orderRepositoryIdf;

    @Transactional
    public void create(DeliveryIdf deliveryIdf) {
        OrdersIdf orders = orderRepositoryIdf.findById(deliveryIdf.getOrdersNo()).orElseThrow(IllegalArgumentException::new);
        deliveryRepositoryIdf.save(deliveryIdf);
    }

    public List<DeliveryIdf> retrieveDeliveriesByOrdersNo(long ordersNo) {
        return deliveryRepositoryIdf.findAllByOrdersNo(ordersNo).orElseThrow(IllegalArgumentException::new);
    }
}
