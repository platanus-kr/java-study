package com.jpapractice01.unit.byreference;


import com.jpapractice01.byreference.delivery.DeliveryRef;
import com.jpapractice01.byreference.delivery.DeliveryServiceRef;
import com.jpapractice01.byreference.order.ItemRef;
import com.jpapractice01.byreference.order.ItemServiceRef;
import com.jpapractice01.byreference.order.OrderCustomerRef;
import com.jpapractice01.byreference.order.OrderServiceRef;
import com.jpapractice01.byreference.order.OrderStatusRef;
import com.jpapractice01.byreference.order.OrdersRef;
import com.jpapractice01.byreference.order.ReceiveCustomerRef;
import com.jpapractice01.byreference.sku.SkuRef;
import com.jpapractice01.byreference.sku.SkuRepositoryRef;
import com.jpapractice01.utils.JpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class ByReferenceTest extends JpaTest {

    @Autowired
    private OrderServiceRef orderServiceRef;

    @Autowired
    private ItemServiceRef itemServiceRef;

    @Autowired
    private DeliveryServiceRef deliveryServiceRef;

    @Autowired
    private SkuRepositoryRef skuRepositoryRef;

    @BeforeEach
    @Transactional
    void beforeEach() {
        SkuRef 첫번째_상품 = new SkuRef("SKU_CODE_1", "코카콜라", 700L);
        SkuRef 두번째_상품 = new SkuRef("SKU_CODE_2", "팹시제로", 500L);

        skuRepositoryRef.save(첫번째_상품);
        skuRepositoryRef.save(두번째_상품);
    }

    @Test
    void createOrderAndRetrieveByItem() {

        // given
        OrderCustomerRef 주문자_정보 = new OrderCustomerRef();
        ReceiveCustomerRef 수령자_정보 = new ReceiveCustomerRef();

        OrdersRef 새_주문 = new OrdersRef(주문자_정보, 수령자_정보, OrderStatusRef.PURCHASED);
        orderServiceRef.save(새_주문);

        final long 새_주문번호 = 새_주문.getId();

        // when -> orderItems
        SkuRef 첫번째_상품 = skuRepositoryRef.findById(1L).orElseThrow();
        SkuRef 두번째_상품 = skuRepositoryRef.findById(2L).orElseThrow();

        ItemRef 첫번째_주문_상품 = new ItemRef(첫번째_상품, 600L, 100L, 3);
        ItemRef 두번째_주문_상품 = new ItemRef(두번째_상품, 500L, 0, 3);

        itemServiceRef.appendItem(새_주문번호, 첫번째_주문_상품);
        itemServiceRef.appendItem(새_주문번호, 두번째_주문_상품);

        // then
        List<ItemRef> itemRefs = itemServiceRef.retrieveOrderItems(새_주문번호);
        List<Long> collect = itemRefs.stream().map(ItemRef::getId).toList();

        assertThat(collect.size()).isEqualTo(2);
    }

    @Test
    void createOrderAndRetrieveByDelivery() {
        // given
        OrderCustomerRef 주문자_정보 = new OrderCustomerRef();
        ReceiveCustomerRef 수령자_정보 = new ReceiveCustomerRef();

        OrdersRef 새_주문 = new OrdersRef(주문자_정보, 수령자_정보, OrderStatusRef.PURCHASED);
        orderServiceRef.save(새_주문);

        final long 새_주문번호 = 새_주문.getId();

        // when -> orderDeliveries
        DeliveryRef 배송_정보 = new DeliveryRef("1234567", 10L);

        deliveryServiceRef.appendDelivery(새_주문번호, 배송_정보);

        // then
        List<DeliveryRef> deliveries = deliveryServiceRef.retrieveOrderDeliveries(새_주문번호); // << 여기가 차이남
        List<Long> collect = deliveries.stream().map(DeliveryRef::getId).toList();

        assertThat(collect.size()).isEqualTo(1);
    }
}
