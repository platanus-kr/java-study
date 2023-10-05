package c.e.couchbase01;

import c.e.couchbase01.domain.Item;
import c.e.couchbase01.domain.OrderRepository;
import c.e.couchbase01.domain.OrderStatus;
import c.e.couchbase01.domain.Orders;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class CouchbaseRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    //    @Transactional
    @DisplayName("아니 그게 아니고 잠깐만요")
    @Test
    void test() {
        List<Item> items = List.of(
                new Item("00001", 1),
                new Item("00002", 2),
                new Item("00003", 3)
        );

        Orders o = new Orders(items, OrderStatus.PAYED);

        orderRepository.save(o);

    }


}
