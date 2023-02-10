package com.example.redisdatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductRedisTemplateRepository {
	public final StringRedisTemplate redisTemplate;
	
	// 이렇게 하면 검색은 되는데 key를 검색하는거지 value를 검색하는게 아님.
	public List<String> findByNameLike(String search) {
		List<String> result = new ArrayList<>();
		
		redisTemplate.execute(new RedisCallback<List<String>>() {
			@Override
			public List<String> doInRedis(RedisConnection connection) throws DataAccessException {
				ScanOptions options = ScanOptions.scanOptions().match("product:*").build();
				Cursor<Entry<byte[], byte[]>> entries = connection.hScan(search.getBytes(), options);
				
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
}
