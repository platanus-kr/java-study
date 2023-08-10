package com.jpapractice01.unit.byreference;


import com.jpapractice01.byreference.order.Item;
import com.jpapractice01.byreference.order.OrderService;
import com.jpapractice01.byreference.order.Orders;
import com.jpapractice01.byreference.order.OrderCustomer;
import com.jpapractice01.byreference.order.OrderRepository;
import com.jpapractice01.byreference.order.OrderStatus;
import com.jpapractice01.byreference.order.ReceiveCustomer;
import com.jpapractice01.byreference.sku.Sku;
import com.jpapractice01.utils.JpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("NonAsciiCharacters")
public class OrdersTest extends JpaTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderRepository orderRepository;

    @Test
    void test() {
        OrderCustomer 주문자_정보 = new OrderCustomer();
        ReceiveCustomer 수령자_정보 = new ReceiveCustomer();

        Orders 새_주문 = new Orders(1L, 주문자_정보, 수령자_정보, OrderStatus.PURCHASED);

        orderRepository.save(새_주문);

        Sku 첫번째_상품 = new Sku(1L, "SKU_CODE_1", "코카콜라", 700L);
        Item 첫번째_주문아이템 = new Item(1L, 새_주문, 첫번째_상품, 600L, 100L, 3);

        Sku 두번째_상품 = new Sku(2L, "SKU_CODE_2", "팹시제로", 500L);
        Item 두번째_주문아이템 = new Item(1L, 새_주문, 두번째_상품, 500L, 0, 3);

        새_주문.addItem(첫번째_주문아이템);
        새_주문.addItem(두번째_주문아이템);
    }

    @Test
    void test2() {
        orderService.create();
        orderService.retrieveAll();
    }
}
