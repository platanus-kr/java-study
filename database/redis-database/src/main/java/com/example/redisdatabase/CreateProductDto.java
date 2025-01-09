package com.example.redisdatabase;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CreateProductDto implements Serializable {
	@NotBlank
	private String name;
	@NotBlank
	private double price;
	
}
