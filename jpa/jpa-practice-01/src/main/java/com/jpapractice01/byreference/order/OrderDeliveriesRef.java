package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.delivery.DeliveryRef;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class OrderDeliveriesRef {
    @OneToMany(mappedBy = "ordersRef", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<DeliveryRef> deliveries = new ArrayList<>();

    public void add(DeliveryRef deliveryRef, OrdersRef ordersRef) {
        deliveryRef.setOrdersRef(ordersRef);
        this.deliveries.add(deliveryRef);
    }

    public List<DeliveryRef> getDeliveries() {
        return this.deliveries;
    }
}
