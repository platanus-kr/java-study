package com.example.redisdatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

@SpringBootTest
class RedisDatabaseApplicationTests {

    @Autowired
    private ProductService productService;
    
    @Autowired
    private RedisTemplate redisTemplate;

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
    
    //@Test
    void 상품생성요청(){
        CreateProductDto request = CreateProductDto.builder()
                .name("테스트상품")
                .price(1000L)
                .build();
        ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/product")
                .then()
                .log().all().extract();
    }
    
    @Test
    void RedisTemplate_SCAN_쿼리테스트() {
        final String search = "apple";
        List<Product> strings = productService.retrieveProductsTest(search);
        System.out.println(strings.size());
        for (Product string : strings) {
            System.out.println(string);
        }
    }

    @Test
    void RedisTemplate_SCAN_전체쿼리테스트() {
        List<Product> products = productService.retrieveProducts();
        products.forEach(v -> System.out.println(v.toString()));
    }
    
    @Test
    void ResdisTemplate_GetHashKey(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        String what = (String) hashOperations.get("", "?");
        System.out.println(what);
    }

}
