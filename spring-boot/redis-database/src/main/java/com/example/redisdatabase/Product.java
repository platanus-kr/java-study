package com.example.redisdatabase;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
@RedisHash("product")
@TypeAlias("product")
public class Product implements Serializable {
    @Id private String id;
    @Indexed private String name;
    private double price;
}
