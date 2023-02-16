package persistence.mongodbdatabase;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	final private ProductMongoTemplateRepository mongoTemplateRepository;
	final private ProductSpringDataMongoRepository springDataRepository;
	
	public Product createProduct(Product product) {
		return mongoTemplateRepository.addProduct(product);
	}
	
	public List<Product> getAllProducts() {
		return mongoTemplateRepository.getAllProducts();
	}
	
	public Product getProductById(String id) {
		return mongoTemplateRepository.getProductById(id);
	}
	
	public List<Product> searchProductsByName(String name) {
		return mongoTemplateRepository.findByNameLike(name);
	}
	
	
}
