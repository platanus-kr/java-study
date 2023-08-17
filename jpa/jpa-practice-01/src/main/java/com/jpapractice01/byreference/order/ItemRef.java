package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.sku.SkuRef;
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


@Table(name = "ITEMREF")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class ItemRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private OrdersRef ordersRef;

    // 직접 참조
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private SkuRef skuRef;

    private long purchasePrice;

    private long discountPrice;

    private long amount;

    public ItemRef(SkuRef skuRef, long purchasePrice, long discountPrice, int amount) {
        this.skuRef = skuRef;
        this.amount = amount;
        this.discountPrice = discountPrice;
        this.purchasePrice = purchasePrice;
    }

    public Long getId() {
        return id;
    }

    public OrdersRef getOrdersRef() {
        return ordersRef;
    }

    public void setOrdersRef(OrdersRef ordersRef) {
        this.ordersRef = ordersRef;
    }

    public SkuRef getSkuRef() {
        return skuRef;
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
