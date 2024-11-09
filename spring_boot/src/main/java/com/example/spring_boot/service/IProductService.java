package com.example.spring_boot.service;
import com.example.spring_boot.common.ProductNotFoundException;
import com.example.spring_boot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IProductService {
    Page<Product> findAll(Pageable pageable);
    void save(Product product);
    Product findById(Long id) throws ProductNotFoundException;
}
