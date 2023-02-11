package com.example.redisdatabase;


import java.util.List;

public interface ProductService {

    public Product getProduct(String id);

    Product createProduct(Product product);
    
    void deleteProduct(Product product);
    
    Product updateProduct(Product product);
    
    List<Product> retrieveProducts(String search);
    
    List<Product> retrieveProducts();
    
    List<Product> retrieveProductsTest(String search);
}
