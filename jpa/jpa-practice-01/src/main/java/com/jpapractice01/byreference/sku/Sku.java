package com.jpapractice01.byreference.sku;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Sku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private long price;

    public Sku(String code, String name, long price) {
        this.code = code;
        this.name = name;
        this.price= price;
    }

    public Sku(long id, String code, String name, long price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price= price;
    }
}
