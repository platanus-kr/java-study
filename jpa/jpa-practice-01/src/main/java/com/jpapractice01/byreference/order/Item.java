package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.sku.Sku;
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
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 직접 참조
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Orders orders;

    // 직접 참조
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Sku sku;

    private long purchasePrice;

    private long discountPrice;

    private long amount;

    public Item(Sku sku, long purchasePrice, long discountPrice, int amount) {
        this.sku = sku;
        this.amount = amount;
        this.discountPrice = discountPrice;
        this.purchasePrice = purchasePrice;
    }

    public Long getId() {
        return id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Sku getSku() {
        return sku;
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
