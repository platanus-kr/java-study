package persistence.mongodbdatabase;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class ProductMongoTemplateRepository {
	
	final private MongoTemplate mongoTemplate;
	
	public List<Product> getAllProducts(){
		return mongoTemplate.findAll(Product.class);
	}
	
	public Product getProductById(String id) {
		return mongoTemplate.findById(id, Product.class);
	}
	
	public Product addProduct(Product product){
		return mongoTemplate.save(product);
	}
	
	//upsert
	public Product updateProduct(Product product){
		return mongoTemplate.save(product);
	}
	
	public void deleteProduct(String id){
		Product product = getProductById(id);
		mongoTemplate.remove(product);
	}
	
	public List<Product> findByNameLike(String name) {
		return mongoTemplate.find(query(where("name").regex(name, "i")), Product.class);
	}
	
}
