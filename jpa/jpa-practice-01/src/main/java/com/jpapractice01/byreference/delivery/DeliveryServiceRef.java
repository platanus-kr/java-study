package com.jpapractice01.byreference.delivery;

import com.jpapractice01.byreference.order.OrderRepositoryRef;
import com.jpapractice01.byreference.order.OrdersRef;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryServiceRef {
    private final OrderRepositoryRef orderRepositoryRef;

    @Transactional
    public void appendDelivery(long orderId, DeliveryRef deliveryRef) {
        OrdersRef findOrder = orderRepositoryRef.findById(orderId).orElseThrow(IllegalArgumentException::new);
        findOrder.addDelivery(deliveryRef);
    }

    @Transactional
    public List<DeliveryRef> retrieveOrderDeliveries(long orderId) {
        OrdersRef ordersRef = orderRepositoryRef.findById(orderId).orElseThrow(IllegalArgumentException::new);

        List<DeliveryRef> deliveries = ordersRef.getDeliveries();
        deliveries.size(); // DTO 변환 등등의 작업을 위해 컬렉션에 접근하여 엔티티 명시 (컬렉션 접근)
        return deliveries;
    }
}
