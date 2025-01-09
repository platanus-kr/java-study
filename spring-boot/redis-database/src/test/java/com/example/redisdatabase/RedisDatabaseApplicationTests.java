package com.example.redisdatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RedisDatabaseApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    void contextLoads() {
    }

    @Test
    void 상품생성_상품가져오기() {
        Product product = new Product("1", "테스트 상품", 10.0);
        productService.createProduct(product);
        Product productFromDb = productService.getProduct("1");
        assertEquals("1", productFromDb.getId());
        assertEquals("테스트 상품", productFromDb.getName());
        assertEquals(10.0, productFromDb.getPrice());
    }

}
