package persistence.mongodbdatabase;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSpringDataMongoRepository extends MongoRepository<Product, String> {
	List<Product> findByNameContaining(String name);
}
