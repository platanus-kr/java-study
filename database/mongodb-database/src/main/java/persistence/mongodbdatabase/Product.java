package persistence.mongodbdatabase;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@Document(collection = "product")
public class Product implements Serializable {
	@Id private String id;
	private String name;
	private double price;
}
