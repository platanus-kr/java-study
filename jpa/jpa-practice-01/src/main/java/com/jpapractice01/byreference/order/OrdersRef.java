package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.delivery.DeliveryRef;
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

@Table(name = "ORDERSREF")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class OrdersRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private OrderItemsRef orderItemsRef = new OrderItemsRef();

    @Embedded
    private OrderDeliveriesRef orderDeliveriesRef = new OrderDeliveriesRef();

    @Embedded
    private OrderCustomerRef orderCustomerRef;

    @Embedded
    private ReceiveCustomerRef receiveCustomerRef;

    @Enumerated
    private OrderStatusRef status;

    public OrdersRef(long l, OrderCustomerRef orderCustomerRef, ReceiveCustomerRef receiveCustomerRef, OrderStatusRef status) {
        this.id = l;
        this.orderCustomerRef = orderCustomerRef;
        this.receiveCustomerRef = receiveCustomerRef;
        this.status = status;
    }

    public OrdersRef(OrderCustomerRef orderCustomerRef, ReceiveCustomerRef receiveCustomerRef, OrderStatusRef status) {
        this.orderCustomerRef = orderCustomerRef;
        this.receiveCustomerRef = receiveCustomerRef;
        this.status = status;
    }

    public List<ItemRef> getItems() {
        return this.orderItemsRef.getItemRefs();
    }

    public List<DeliveryRef> getDeliveries() {
        return this.orderDeliveriesRef.getDeliveries();
    }

    public void addItem(ItemRef itemRef) {
        this.orderItemsRef.add(itemRef, this);
    }

    public void addDelivery(DeliveryRef deliveryRef) {
        this.orderDeliveriesRef.add(deliveryRef, this);
    }

    public Long getId() {
        return id;
    }

    public OrderItemsRef getOrderItemsRef() {
        return orderItemsRef;
    }

    public OrderDeliveriesRef getOrderDeliveriesRef() {
        return orderDeliveriesRef;
    }

    public OrderCustomerRef getOrderCustomerRef() {
        return orderCustomerRef;
    }

    public ReceiveCustomerRef getReceiveCustomerRef() {
        return receiveCustomerRef;
    }

    public OrderStatusRef getStatus() {
        return status;
    }
}
