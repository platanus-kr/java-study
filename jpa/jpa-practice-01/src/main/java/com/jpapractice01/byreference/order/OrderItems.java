package com.jpapractice01.byreference.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Embeddable
@NoArgsConstructor
public class OrderItems {

    // 여기도 직접참조
    @OneToMany(mappedBy = "orders", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<Item> items = new ArrayList<>();

    public void add(Item item, Orders orders) {
        // validate already added item....

        item.setOrders(orders);
        this.items.add(item);
    }

    public List<Item> getItems() {
        return this.items;
    }

}
