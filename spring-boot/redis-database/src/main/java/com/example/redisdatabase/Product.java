package com.example.redisdatabase;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@RedisHash("product")
public class Product implements Serializable {
    private String id;
    private String name;
    private double price;
}
