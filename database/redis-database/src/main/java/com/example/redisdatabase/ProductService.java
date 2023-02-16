package com.example.redisdatabase;


import java.util.List;

public interface ProductService {

    public Product getProduct(String id);

    void createProduct(Product product);
    
    Long deleteProduct(Product product);
    
//    Product updateProduct(Product product);
    
//    List<Product> retrieveProducts(String search);
    
//    List<Product> retrieveProducts();
    
    List<Product> retrieveProductsTest(String search);

    List<Product> retrieveProducts();
}
