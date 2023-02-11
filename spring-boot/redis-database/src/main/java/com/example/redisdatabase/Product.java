package com.example.redisdatabase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
@RedisHash("product")
public class Product implements Serializable {
    @Id private String id;
    private String name;
    private double price;
}
