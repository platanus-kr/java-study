package com.example.redisdatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductCrudRepository productCrudRepository;
	private final ProductRedisTemplateRepository productRedisTemplateRepository;

    @Override
    public Product getProduct(String id) {
//        return productCrudRepository.findById(id).orElse(null);
		return productRedisTemplateRepository.findById(id);
    }

    @Override
    public void createProduct(Product product) {
//        return productCrudRepository.save(product);
//        productCrudRepository.save(product);
		productRedisTemplateRepository.save(product);
	}
    
	@Override
    public Long deleteProduct(Product product) {
//		productCrudRepository.delete(product);
		return productRedisTemplateRepository.delete(product);
    }
	
//	@Override
//	public Product updateProduct(Product product) {
//		return productCrudRepository.save(product);
//	}
	
//	@Override
//	public List<Product> retrieveProducts(String search) {
//		return productCrudRepository.findByNameContains(search);
//	}
	
//	@Override
//	public List<Product> retrieveProducts(){
//		List<Product> finds = productCrudRepository.findAll();
//		for (Product find : finds) {
//			System.out.println(find);
//		}
//		return finds;
//	}

	public List<Product> retrieveProducts(){
		Map<String, Product> all = productRedisTemplateRepository.findAll();
		List<Product> products = new ArrayList<>();
		for (Map.Entry<String, Product> stringProductEntry : all.entrySet()) {
//			products.add(stringProductEntry.getValue());
		}
		return products;
	}
	
	public List<Product> retrieveProductsTest(String search) {
		String likeSearch = search;
		return productRedisTemplateRepository.findByNameLike(likeSearch);
	}
}
