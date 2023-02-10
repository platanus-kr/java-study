package com.example.redisdatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRedisTemplateRepository {
	public final StringRedisTemplate redisTemplate;
	
	// 이렇게 하면 검색은 되는데 key를 검색하는거지 value를 검색하는게 아님.
	
	public List<String> findByNameLike(String search) {
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
	
	private String getHashKey(String key, String mapkey) {
		// https://www.programcreek.com/java-api-examples/?class=org.springframework.data.redis.core.HashOperations&method=get
		HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
		return hashOperations.get(key, mapkey);
	}
}
