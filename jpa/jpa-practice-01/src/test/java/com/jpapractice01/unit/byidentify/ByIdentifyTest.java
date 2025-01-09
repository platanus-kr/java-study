package com.jpapractice01.unit.byidentify;

import com.jpapractice01.byidentifier.delivery.DeliveryIdf;
import com.jpapractice01.byidentifier.delivery.DeliveryServiceIdf;
import com.jpapractice01.byidentifier.order.ItemIdf;
import com.jpapractice01.byidentifier.order.ItemServiceIdf;
import com.jpapractice01.byidentifier.order.OrderCustomerIdf;
import com.jpapractice01.byidentifier.order.OrderServiceIdf;
import com.jpapractice01.byidentifier.order.OrderStatusIdf;
import com.jpapractice01.byidentifier.order.OrdersIdf;
import com.jpapractice01.byidentifier.order.ReceiveCustomerIdf;
import com.jpapractice01.byidentifier.sku.SkuIdf;
import com.jpapractice01.byidentifier.sku.SkuServiceIdf;
import com.jpapractice01.utils.JpaTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ByIdentifyTest extends JpaTest {
    @Autowired
    private OrderServiceIdf orderServiceIdf;

    @Autowired
    private ItemServiceIdf itemServiceIdf;

    @Autowired
    private DeliveryServiceIdf deliveryServiceIdf;

    @Autowired
    private SkuServiceIdf skuServiceIdf;

    @BeforeEach
    @Transactional
    void beforeEach() {
        SkuIdf 첫번째_상품 = new SkuIdf("SKU_CODE_1", "코카콜라", 700L);
        SkuIdf 두번째_상품 = new SkuIdf("SKU_CODE_2", "팹시제로", 500L);

        skuServiceIdf.create(첫번째_상품);
        skuServiceIdf.create(두번째_상품);
    }

    @Test
    void createOrderAndRetrieveByItem() {
        // given
        OrderCustomerIdf 주문자_정보 = new OrderCustomerIdf();
        ReceiveCustomerIdf 수령자_정보 = new ReceiveCustomerIdf();

        OrdersIdf 새_주문 = new OrdersIdf(주문자_정보, 수령자_정보, OrderStatusIdf.PURCHASED);
        orderServiceIdf.save(새_주문);

        final long 새_주문번호 = 새_주문.getId();

        // when -> items
        SkuIdf 첫번째_상품 = skuServiceIdf.findById(1L); //  maybe...
        SkuIdf 두번째_상품 = skuServiceIdf.findById(2L);

        ItemIdf 첫번째_주문_상품 = new ItemIdf(첫번째_상품.getId(), 600L, 100L, 3);
        ItemIdf 두번째_주문_상품 = new ItemIdf(두번째_상품.getId(), 500L, 0, 3);

        itemServiceIdf.appendItem(새_주문번호, 첫번째_주문_상품);
        itemServiceIdf.appendItem(새_주문번호, 두번째_주문_상품);

        // then
        List<ItemIdf> itemIdfs = itemServiceIdf.retrieveOrderItems(새_주문번호);
        List<Long> collect = itemIdfs.stream().map(ItemIdf::getId).toList();

        assertThat(collect.size()).isEqualTo(2);
    }

    @Test
    void createOrderAndRetrieveByDelivery() {
        // given
        OrderCustomerIdf 주문자_정보 = new OrderCustomerIdf();
        ReceiveCustomerIdf 수령자_정보 = new ReceiveCustomerIdf();

        OrdersIdf 새_주문 = new OrdersIdf(주문자_정보, 수령자_정보, OrderStatusIdf.PURCHASED);
        orderServiceIdf.save(새_주문);

        final long 새_주문번호 = 새_주문.getId();

        // when -> deliveries
        DeliveryIdf 배송_정보 = new DeliveryIdf(새_주문번호, "7654321", 10L);

        deliveryServiceIdf.create(배송_정보);

        // then
        List<DeliveryIdf> deliveries = deliveryServiceIdf.retrieveDeliveriesByOrdersNo(새_주문번호); // << 여기가 차이남
        List<Long> collect = deliveries.stream().map(DeliveryIdf::getId).toList();

        assertThat(collect.size()).isEqualTo(1);
    }

}
