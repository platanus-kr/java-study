package com.jpapractice01.byreference.delivery;

import com.jpapractice01.byreference.order.OrdersRef;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Table(name = "DELIVERYREF")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String invoice;

    // 직접 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private OrdersRef ordersRef;

    private long amount;

    public DeliveryRef(String invoice, long amount){
        this.invoice = invoice;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public String getInvoice() {
        return invoice;
    }

    public long getAmount() {
        return amount;
    }

    public OrdersRef getOrdersRef() {
        return ordersRef;
    }

    public void setOrdersRef(OrdersRef ordersRef) {
        this.ordersRef = ordersRef;
    }
}
