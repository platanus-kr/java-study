package com.jpapractice01.byreference.sku;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Table(name = "SKUREF")
@Entity
@NoArgsConstructor
public class SkuRef {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private long price;

    public SkuRef(String code, String name, long price) {
        this.code = code;
        this.name = name;
        this.price= price;
    }

    public SkuRef(long id, String code, String name, long price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price= price;
    }
}
