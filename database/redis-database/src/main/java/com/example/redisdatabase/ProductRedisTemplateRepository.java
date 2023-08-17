package com.example.redisdatabase;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class ProductRedisTemplateRepository {
    private final StringRedisTemplate redisTemplate;

    private final RedisTemplate<String, Product> productRedisTemplate;
    private final HashOperations<String, String, Product> hashOps;


    // 이렇게 하면 검색은 되는데 key를 검색하는거지 value를 검색하는게 아님.
    // 모 부트캠프에서 이렇게 하라고 가르치는듯.....
    public List<String> findByNameLikeOld(String search) {
        List<String> result = new ArrayList<>();

        // https://velog.io/@meme2367/EnjoyDelivery-%EC%9D%B4%EC%8A%88-3.-%EC%9E%A5%EB%B0%94%EA%B5%AC%EB%8B%88-%EA%B8%B0%EB%8A%A5%EC%97%90-Redis-ON-%EB%AA%85%EB%A0%B9%EC%96%B4%EB%A5%BC-O1-%EB%AA%85%EB%A0%B9%EC%96%B4%EB%A1%9C-%EB%B3%80%EA%B2%BD
        //RedisSerializer keySerializer = redisTemplate.getKeySerializer();
        //
        //RedisSerializer hashValueSerializer = redisTemplate.getHashValueSerializer();
        //String key = getHashKey(search);

        redisTemplate.execute(new RedisCallback<List<String>>() {
            @Override
            public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
                ScanOptions options = ScanOptions.scanOptions().match("product:name:*").build();
                Cursor<Entry<byte[], byte[]>> entries = connection.hScan("우유".getBytes(), options);

                while (entries.hasNext()) {
                    Entry<byte[], byte[]> entry = entries.next();
                    byte[] actualKey = entry.getKey();
                    result.add(new String(actualKey));
                }

                return result;
            }
        });

        return result;
    }


    // 사용 안함
    private String getHashKey(String key, String mapkey) {
        // https://www.programcreek.com/java-api-examples/?class=org.springframework.data.redis.core.HashOperations&method=get
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        return hashOperations.get(key, mapkey);
    }


    public void save(Product product) {
//        productHashOperations.put(product.getClass().getSimpleName(), product.getId(), product);
        product.setId();
//        productHashOperations.put("product", product.getId(), product);
//        productHashOperations.put("product:" + product.getId(), "name", product.getName());
//        productHashOperations.put("product:" + product.getId(), "price", product.getPrice());
        String key = "product";
        String id = product.getId();
        hashOps.put(key, id, product);
    }

    public Long delete(Product product) {
//        return productHashOperations.delete("product", product.getId());
        return 0L;
    }

    public Product findById(String id) {
        String key = "product";
        return hashOps.get(key, id);
    }

    public List<Product> findByNameLike(String pattern) {
        String key = "product";
        List<Product> results = hashOps.scan(key, ScanOptions.scanOptions().match("*" + pattern + "*").build())
                .stream().map(Map.Entry::getValue)
                .collect(Collectors.toList());
        return results;
    }

    public Map<String, Product> findAll() {
        return hashOps.entries("product");
    }


}
