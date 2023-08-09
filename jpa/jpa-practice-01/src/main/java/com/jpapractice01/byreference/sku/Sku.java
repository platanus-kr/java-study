package com.jpapractice01.byreference.sku;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Sku {
    @Id
    @GeneratedValue
    private long id;

    private String code;

    private String name;

    private long price;
}
