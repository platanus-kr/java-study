package persistence.mongodbdatabase;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	final private ProductMongoTemplateRepository mongoTemplateRepository;
	final private ProductSpringDataMongoRepository springDataRepository;
	
	
	
	
}
