package persistence.mongodbdatabase;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Document(collection = "product")
public class Product implements Serializable {
	private static final long serialVersionUID = 4412283486447049722L;
	@Id private String id;
	private String name;
	private double price;
}
