package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.sku.Sku;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
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
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Sku item;

    private long purchasePrice;

    private long discountPrice;

    private long amount;

    @Embedded
    private final ItemExports export = new ItemExports();

}
