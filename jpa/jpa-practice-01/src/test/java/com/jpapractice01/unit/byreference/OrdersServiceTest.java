package com.jpapractice01.unit.byreference;


import com.jpapractice01.byreference.order.Item;
import com.jpapractice01.byreference.order.OrderCustomer;
import com.jpapractice01.byreference.order.OrderService;
import com.jpapractice01.byreference.order.OrderStatus;
import com.jpapractice01.byreference.order.Orders;
import com.jpapractice01.byreference.order.ReceiveCustomer;
import com.jpapractice01.byreference.sku.Sku;
import com.jpapractice01.byreference.sku.SkuRepository;
import com.jpapractice01.utils.JpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class OrdersServiceTest extends JpaTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SkuRepository skuRepository;

    @BeforeEach
    @Transactional
    void beforeEach() {
        Sku 첫번째_상품 = new Sku("SKU_CODE_1", "코카콜라", 700L);
        Sku 두번째_상품 = new Sku("SKU_CODE_2", "팹시제로", 500L);

        skuRepository.save(첫번째_상품);
        skuRepository.save(두번째_상품);
    }

    @Test
    void createOrder() {

        // given
        OrderCustomer 주문자_정보 = new OrderCustomer();
        ReceiveCustomer 수령자_정보 = new ReceiveCustomer();

        // when
        Orders 새_주문 = new Orders(주문자_정보, 수령자_정보, OrderStatus.PURCHASED);
        orderService.save(새_주문);

        final long 저장된_주문번호 = 새_주문.getId();

        Sku findFirst = skuRepository.findById(1L).orElseThrow();
        Sku findSecond = skuRepository.findById(2L).orElseThrow();

        Item 첫번째_주문아이템 = new Item(findFirst, 600L, 100L, 3);
        Item 두번째_주문아이템 = new Item(findSecond, 500L, 0, 3);

        // when
//        Orders 찾은_주문 = orderService.findById(저장된_주문번호);
        final long 새_주문번호 = 새_주문.getId();

        orderService.appendItem(새_주문번호, 첫번째_주문아이템);
        orderService.appendItem(새_주문번호, 두번째_주문아이템);

        // then
//        Orders 검증_주문 = orderService.findById(찾은_주문번호);
//        List<Item> items = 검증_주문.getItems();
//        List<Long> retrieveOrderItemNos = items.stream().map(Item::getId).toList();
//
//        assertThat(retrieveOrderItemNos.size()).isEqualTo(2L);
        orderService.retrieveAll();
    }
}
