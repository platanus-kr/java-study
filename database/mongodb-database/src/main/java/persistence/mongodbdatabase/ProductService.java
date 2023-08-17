package persistence.mongodbdatabase;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	final private ProductMongoTemplateRepository mongoTemplateRepository;
	final private ProductSpringDataMongoRepository springDataRepository;
	
	public Product createProductFromMT(Product product) {
		return mongoTemplateRepository.addProduct(product);
	}
	
	public List<Product> getAllProductsFromMT() {
		return mongoTemplateRepository.getAllProducts();
	}
	
	public Product getProductByIdFromMT(String id) {
		return mongoTemplateRepository.getProductById(id);
	}
	
	public List<Product> searchProductsByNameFromMT(String name) {
		return mongoTemplateRepository.findByNameLike(name);
	}
	
	public Product createProductFromSD(Product product){
		return springDataRepository.save(product);
	}
	
	public List<Product> getAllProductsFromSD(){
		return springDataRepository.findAll();
	}
	
	public Product getProductByIdFromSD(String id){
		return springDataRepository.findById(id).orElse(new Product());
	}
	
	public List<Product> searchProductsByNameFromSD(String name) {
		return springDataRepository.findByNameContaining(name);
	}
	
}
