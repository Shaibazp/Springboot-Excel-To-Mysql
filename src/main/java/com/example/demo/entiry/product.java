package com.example.demo.entiry;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class product 
{
	@Id
	private Long productId;
	private String productName;
	private String productDesc;
	private Double productPrice;
}
