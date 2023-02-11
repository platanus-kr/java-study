package com.example.redisdatabase;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductCrudRepository productCrudRepository;
	private final ProductRedisTemplateRepository productRedisTemplateRepository;

    @Override
    public Product getProduct(String id) {
        return productCrudRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productCrudRepository.save(product);
    }
    
	@Override
    public void deleteProduct(Product product) {
		productCrudRepository.delete(product);
    }
	
	@Override
	public Product updateProduct(Product product) {
		return productCrudRepository.save(product);
	}
	
	@Override
	public List<Product> retrieveProducts(String search) {
		return productCrudRepository.findByNameContains(search);
	}
	
	@Override
	public List<Product> retrieveProducts(){
		List<Product> finds = productCrudRepository.findAll();
		for (Product find : finds) {
			System.out.println(find);
		}
		return finds;
	}
	
	public List<Product> retrieveProductsTest(String search) {
		String likeSearch = "*" + search + "*";
		return productRedisTemplateRepository.findByNameLike(likeSearch);
	}
}
