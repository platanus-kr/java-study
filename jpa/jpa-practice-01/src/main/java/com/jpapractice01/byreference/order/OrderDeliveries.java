package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.delivery.Delivery;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class OrderDeliveries {
    @OneToMany(mappedBy = "orders", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<Delivery> deliveries = new ArrayList<>();

    public void add(Delivery delivery, Orders orders) {
        delivery.setOrders(orders);
        this.deliveries.add(delivery);
    }

    public List<Delivery> getDeliveries() {
        return this.deliveries;
    }
}
