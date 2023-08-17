package com.jpapractice01.byidentifier.order;

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

@Table(name = "ITEMIDF")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemIdf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private OrdersIdf ordersIdf;

    // 간접 참조
    private Long skuNo;

    private long purchasePrice;

    private long discountPrice;

    private long amount;

    public ItemIdf(Long skuNo, long purchasePrice, long discountPrice, int amount) {
        this.skuNo = skuNo;
        this.amount = amount;
        this.discountPrice = discountPrice;
        this.purchasePrice = purchasePrice;
    }

    public Long getId() {
        return id;
    }

    public OrdersIdf getOrdersIdf() {
        return ordersIdf;
    }

    public void setOrdersIdf(OrdersIdf ordersIdf) {
        this.ordersIdf = ordersIdf;
    }

    public Long getSkuNo() {
        return skuNo;
    }

    public void setSkuNo(long skuNo) {
        this.skuNo = skuNo;
    }

    public long getPurchasePrice() {
        return purchasePrice;
    }

    public long getDiscountPrice() {
        return discountPrice;
    }

    public long getAmount() {
        return amount;
    }
}
