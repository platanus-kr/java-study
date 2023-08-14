package com.jpapractice01.byidentifier.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "DELIVERYIDF")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryIdf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String invoice;

    // 간접 참조
    private Long ordersNo;

    private long amount;

    public DeliveryIdf(long ordersNo, String invoice, long amount) {
        this.ordersNo = ordersNo;
        this.invoice = invoice;
        this.amount = amount;
    }

    public Long getOrdersNo() {
        return ordersNo;
    }

    public void setOrdersNo(Long ordersNo) {
        this.ordersNo = ordersNo;
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
}
