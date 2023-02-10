package com.example.redisdatabase;

import java.io.Serializable;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RetrieveProductDto implements Serializable {
	private String id;
	private String name;
	private double price;
}
