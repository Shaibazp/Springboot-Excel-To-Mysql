package com.example.demo.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entiry.product;
import com.example.demo.helper.productexelHelper;
import com.example.demo.service.productService;

@RestController
@CrossOrigin("*")
public class productController 
{
	@Autowired
	private productService service;
	
	@PostMapping("/add")
	public ResponseEntity<?> saveFile(@RequestParam MultipartFile file) throws IOException
	{
		if(productexelHelper.checkExcelFormat(file))
		{
			this.service.saves(file);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Success");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please Upload Excel File");
	}
	
	@GetMapping("/all")
	public List<product> getall()
	{
		return this.service.getall();
	}
}
