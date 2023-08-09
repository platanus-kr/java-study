package com.jpapractice01.unit.byreference;


import com.jpapractice01.byreference.order.ReceiveCustomer;
import com.jpapractice01.byreference.order.Item;
import com.jpapractice01.byreference.order.Order;
import com.jpapractice01.byreference.order.OrderItems;
import com.jpapractice01.byreference.sku.Sku;
import com.jpapractice01.utils.JpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public class OrderTest extends JpaTest {

    @BeforeEach
    void beforeEach() {

    }

    @Test
    void test() {
        ReceiveCustomer 주문자정보 =

        Sku 첫번째_상품 = new Sku(1L, "SKU_CODE_1", "코카콜라", 700L);
        Item 첫번째_주문아이템 = new Item(1L, 첫번째_상품, 600L, 100L, 3);

        Sku 두번째_상품 = new Sku(2L, "SKU_CODE_2", "팹시제로", 500L);
        Item 두번째_주문아이템 = new Item(1L, 두번째_상품, 500L, 0, 3);

        List<Item> orderItems = List.of(첫번째_주문아이템, 두번째_주문아이템);

        OrderItems 주문_내_아이템 = new OrderItems();
        Order 새_주문 = new Order();
    }
}
