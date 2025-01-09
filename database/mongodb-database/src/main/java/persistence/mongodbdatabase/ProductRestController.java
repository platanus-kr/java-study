package persistence.mongodbdatabase;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductRestController {
	final private ProductService productService;
	
	@PostMapping
	@ResponseBody
	public Product createProduct(@RequestBody Product product) {
		if (product.getName().isBlank() || product.getPrice() < 1) {
			return null;
		}
		Product created = productService.createProductFromSD(product);
		return created;
	}
	
	@GetMapping
	@ResponseBody
	public Product getProduct(@RequestParam String id) {
		if (id.isBlank()) {
			return null;
		}
		Product find = productService.getProductByIdFromSD(id);
		return find;
	}
	
	@GetMapping("/findAll")
	@ResponseBody
	public List<Product> getAllProduct() {
		return productService.getAllProductsFromSD();
	}
	
	@GetMapping("/search")
	@ResponseBody
	public List<Product> searchProductName(String name) {
		if (name.isBlank()) {
			return new ArrayList<>();
		}
		return productService.searchProductsByNameFromSD(name);
	}
}
