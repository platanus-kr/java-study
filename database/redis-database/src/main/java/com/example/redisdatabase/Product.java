package com.example.redisdatabase;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import java.io.Serializable;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
@RedisHash("product")
public class Product implements Serializable {
    private static final long serialVersionUID = -3328857031466846482L;
    //Cannot deserialize; nested exception is org.springframework.core.serializer.support.SerializationFailedException: Failed to deserialize payload. Is the byte array a result of corresponding serialization for DefaultDeserializer?; nested exception is java.io.InvalidClassException: com.example.redisdatabase.Product; local class incompatible: stream classdesc serialVersionUID = -8728432402978682459, local class serialVersionUID = -3328857031466846482


    @Id private String id;
    @Indexed private String name;
    private double price;

    public void setId() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
