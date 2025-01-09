package com.example.redisdatabase;


public interface ProductService {

    public Product getProduct(String id);

    void createProduct(Product product);
}
