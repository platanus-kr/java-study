package com.jpapractice01.byreference.order;

import com.jpapractice01.byreference.sku.Sku;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void create() {
        OrderCustomer o = new OrderCustomer();
        ReceiveCustomer r = new ReceiveCustomer();

        Orders newOrder = new Orders(o, r, OrderStatus.PURCHASED);

        orderRepository.save(newOrder);

        Sku firstSku = new Sku("SKU_CODE_1", "코카콜라", 700L);
        Item firstItem = new Item( newOrder, firstSku, 600L, 100L, 3);

        Sku secondSku = new Sku( "SKU_CODE_2", "팹시제로", 500L);
        Item secondItem = new Item( newOrder, secondSku, 500L, 0, 3);

        newOrder.addItem(firstItem);
        newOrder.addItem(secondItem);

    }

    public void retrieveAll() {
        List<Orders> all = orderRepository.findAll();
        for (Orders orders : all) {
            for (Item item : orders.getItems()) {
                log.info(String.valueOf(item.getId()));
            }
        }
    }
}
