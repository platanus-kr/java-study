package com.jpapractice01.byreference.order;

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
    private OrderItems items = new OrderItems();

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
        return items.getItems();
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void addItem(Item item) {
        this.items.add(item, this);
    }
}
