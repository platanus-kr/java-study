package com.jpapractice01.byreference.order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Embeddable
@NoArgsConstructor
public class OrderItemsRef {

    // 여기도 직접참조
    @OneToMany(mappedBy = "ordersRef", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private final List<ItemRef> itemRefs = new ArrayList<>();

    public void add(ItemRef itemRef, OrdersRef ordersRef) {
        // validate already added item....

        itemRef.setOrdersRef(ordersRef);
        this.itemRefs.add(itemRef);
    }

    public List<ItemRef> getItemRefs() {
        return this.itemRefs;
    }

}
