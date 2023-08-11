package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.sku.Sku;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Orders orders;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Sku sku;

    private long purchasePrice;

    private long discountPrice;

    private long amount;

    @Embedded
    private final ItemExports export = new ItemExports();

    public Item(Sku sku, long purchasePrice, long discountPrice, int amount) {
        this.sku = sku;
        this.amount= amount;
        this.discountPrice = discountPrice;
        this.purchasePrice = purchasePrice;
    }
}
