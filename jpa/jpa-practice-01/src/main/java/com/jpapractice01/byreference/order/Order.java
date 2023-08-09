package com.jpapractice01.byreference.order;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private OrderItems items;

    @Embedded
    private OrderCustomer orderCustomer;

    @Embedded
    private ReceiveCustomer receiveCustomer;

    @Enumerated
    private OrderStatus status;

    public OrderItems getItems() {
        return items;
    }

    public OrderStatus getStatus() {
        return status;
    }
}
