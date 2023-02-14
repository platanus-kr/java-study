package com.example.redisdatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
	
	public final ProductService productService;
	
	@ResponseBody
	@PostMapping
	public RetrieveProductDto createProduct(@RequestBody CreateProductDto createProductDto) {
		Product product = Product.builder()
				.name(createProductDto.getName())
				.price(createProductDto.getPrice())
				.build();
		productService.createProduct(product);
		return RetrieveProductDto.builder()
				.id(product.getId())
				.name(product.getName())
				.price(product.getPrice())
				.build();
	}
	
	@ResponseBody
	@GetMapping
	public RetrieveProductDto retrieveProduct(@RequestParam(name = "id", required = true) GetProductDto getProductDto) {
		Product product = Product.builder()
				.id(getProductDto.getId())
				.build();
		Product findProduct = productService.getProduct(product.getId());
		if (findProduct == null) {
			throw new IllegalArgumentException("없는 상품입니다.");
		}
		return RetrieveProductDto.builder()
				.id(findProduct.getId())
				.name(findProduct.getName())
				.price(findProduct.getPrice())
				.build();
	}
	
	@ResponseBody
	@GetMapping("/findByName")
	public List<Product> retrieveProductsByName(@RequestParam(name = "name", required = true) String search) {
//		List<Product> findProducts = productService.retrieveProducts(search);
//		return findProducts;
		return new ArrayList<>();
	}
	
	@ResponseBody
	@GetMapping("/findAll")
	public List<Product> retrieveProducts(){
		return productService.retrieveProducts();
//		return new ArrayList<>();
	}
	
}

