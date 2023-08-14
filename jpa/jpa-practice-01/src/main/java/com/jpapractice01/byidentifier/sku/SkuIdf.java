package com.jpapractice01.byidentifier.sku;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Table(name = "SKUIDF")
@Entity
@NoArgsConstructor
public class SkuIdf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    private long price;

    public SkuIdf(String code, String name, long price) {
        this.code = code;
        this.name = name;
        this.price= price;
    }

    public SkuIdf(long id, String code, String name, long price) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.price= price;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }
}
