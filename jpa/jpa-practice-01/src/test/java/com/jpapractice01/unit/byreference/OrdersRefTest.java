package com.jpapractice01.unit.byreference;


import com.jpapractice01.byreference.order.ItemRef;
import com.jpapractice01.byreference.order.OrderCustomerRef;
import com.jpapractice01.byreference.order.OrderStatusRef;
import com.jpapractice01.byreference.order.OrdersRef;
import com.jpapractice01.byreference.order.ReceiveCustomerRef;
import com.jpapractice01.byreference.sku.SkuRef;
import com.jpapractice01.utils.JpaTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class OrdersRefTest extends JpaTest {

    @Test
    void orderCreate() {
        // given
        OrderCustomerRef 주문자_정보 = new OrderCustomerRef();
        ReceiveCustomerRef 수령자_정보 = new ReceiveCustomerRef();

        OrdersRef 새_주문 = new OrdersRef(1L, 주문자_정보, 수령자_정보, OrderStatusRef.PURCHASED);

        SkuRef 첫번째_상품 = new SkuRef(1L, "SKU_CODE_1", "코카콜라", 700L);
        ItemRef 첫번째_주문아이템 = new ItemRef(1L, 새_주문, 첫번째_상품, 600L, 100L, 3);

        SkuRef 두번째_상품 = new SkuRef(2L, "SKU_CODE_2", "팹시제로", 500L);
        ItemRef 두번째_주문아이템 = new ItemRef(2L, 새_주문, 두번째_상품, 500L, 0, 3);

        새_주문.addItem(첫번째_주문아이템);
        새_주문.addItem(두번째_주문아이템);

        // when/then
        List<Long> ids = 새_주문.getItems().stream().map(ItemRef::getId).toList();
        assertThat(ids).containsAnyOf(1L, 2L);
    }
}
