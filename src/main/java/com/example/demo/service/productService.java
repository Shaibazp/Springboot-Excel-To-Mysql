package com.example.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entiry.product;
import com.example.demo.helper.productexelHelper;
import com.example.demo.repository.productRepository;

@Service
public class productService 
{
	@Autowired
	private productRepository repository;
	
	
	public String saves(MultipartFile file) throws IOException
	{
		List<product> list = productexelHelper.getList(file.getInputStream());
		repository.saveAll(list);
		return "Success";
	}
	
	public List<product> getall()
	{
		return repository.findAll();
	}
}
