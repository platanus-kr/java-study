package com.jpapractice01.byreference.delivery;

import com.jpapractice01.byreference.order.Orders;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String invoice;

    // 직접 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Orders orders;
    private long amount;

    public Delivery(String invoice, long amount){
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

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
