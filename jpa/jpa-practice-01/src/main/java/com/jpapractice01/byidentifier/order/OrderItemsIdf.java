package com.jpapractice01.byidentifier.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Embeddable
@NoArgsConstructor
public class OrderItemsIdf {

    // 여기도 직접참조
    @OneToMany(mappedBy = "ordersIdf", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<ItemIdf> itemIdfs = new ArrayList<>();

    public void add(ItemIdf itemIdf, OrdersIdf ordersIdf) {
        // validate already added item....

        itemIdf.setOrdersIdf(ordersIdf);
        this.itemIdfs.add(itemIdf);
    }

    public List<ItemIdf> getItemIdfs() {
        return this.itemIdfs;
    }

}
