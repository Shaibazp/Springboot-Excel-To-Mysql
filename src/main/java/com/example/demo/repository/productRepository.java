package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entiry.product;

public interface productRepository extends JpaRepository<product, Long> {

}
