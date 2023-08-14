package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.delivery.Delivery;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private OrderItems orderItems = new OrderItems();

    @Embedded
    private OrderDeliveries orderDeliveries = new OrderDeliveries();

    @Embedded
    private OrderCustomer orderCustomer;

    @Embedded
    private ReceiveCustomer receiveCustomer;

    @Enumerated
    private OrderStatus status;

    public Orders(long l, OrderCustomer orderCustomer, ReceiveCustomer receiveCustomer, OrderStatus status) {
        this.id = l;
        this.orderCustomer = orderCustomer;
        this.receiveCustomer = receiveCustomer;
        this.status = status;
    }

    public Orders(OrderCustomer orderCustomer, ReceiveCustomer receiveCustomer, OrderStatus status) {
        this.orderCustomer = orderCustomer;
        this.receiveCustomer = receiveCustomer;
        this.status = status;
    }

    public List<Item> getItems() {
        return this.orderItems.getItems();
    }

    public List<Delivery> getDeliveries() {
        return this.orderDeliveries.getDeliveries();
    }

    public void addItem(Item item) {
        this.orderItems.add(item, this);
    }

    public void addDelivery(Delivery delivery) {
        this.orderDeliveries.add(delivery, this);
    }

    public Long getId() {
        return id;
    }

    public OrderItems getOrderItems() {
        return orderItems;
    }

    public OrderDeliveries getOrderDeliveries() {
        return orderDeliveries;
    }

    public OrderCustomer getOrderCustomer() {
        return orderCustomer;
    }

    public ReceiveCustomer getReceiveCustomer() {
        return receiveCustomer;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
