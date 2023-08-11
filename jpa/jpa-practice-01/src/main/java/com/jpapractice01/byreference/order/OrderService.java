package com.jpapractice01.byreference.order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public void save(Orders order) {
        orderRepository.save(order);
    }

    public Orders findById(long id) {
        return orderRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public void appendItem(long orderId, Item item) {
         Orders findOrder = orderRepository.findById(orderId).orElseThrow(IllegalArgumentException::new);
         findOrder.addItem(item);
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
