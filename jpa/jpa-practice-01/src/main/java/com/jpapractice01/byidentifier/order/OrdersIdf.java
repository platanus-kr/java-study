package com.jpapractice01.byidentifier.order;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "ORDERSIDF")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrdersIdf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private OrderItemsIdf orderItemsIdf = new OrderItemsIdf();

    @Embedded
    private OrderCustomerIdf orderCustomerIdf;

    @Embedded
    private ReceiveCustomerIdf receiveCustomerIdf;

    @Enumerated
    private OrderStatusIdf status;

    public OrdersIdf(long l, OrderCustomerIdf orderCustomerIdf, ReceiveCustomerIdf receiveCustomerIdf, OrderStatusIdf status) {
        this.id = l;
        this.orderCustomerIdf = orderCustomerIdf;
        this.receiveCustomerIdf = receiveCustomerIdf;
        this.status = status;
    }

    public OrdersIdf(OrderCustomerIdf orderCustomerIdf, ReceiveCustomerIdf receiveCustomerIdf, OrderStatusIdf status) {
        this.orderCustomerIdf = orderCustomerIdf;
        this.receiveCustomerIdf = receiveCustomerIdf;
        this.status = status;
    }

    public List<ItemIdf> getItems() {
        return this.orderItemsIdf.getItemIdfs();
    }

    public void addItem(ItemIdf itemIdf) {
        this.orderItemsIdf.add(itemIdf, this);
    }

    public Long getId() {
        return id;
    }

    public OrderItemsIdf getOrderItemsIdf() {
        return orderItemsIdf;
    }

    public OrderCustomerIdf getOrderCustomerIdf() {
        return orderCustomerIdf;
    }

    public ReceiveCustomerIdf getReceiveCustomerIdf() {
        return receiveCustomerIdf;
    }

    public OrderStatusIdf getStatus() {
        return status;
    }
}
