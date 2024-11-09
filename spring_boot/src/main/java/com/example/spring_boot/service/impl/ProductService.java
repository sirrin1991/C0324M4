package com.example.spring_boot.service.impl;

import com.example.spring_boot.common.ProductNotFoundException;
import com.example.spring_boot.model.Product;
import com.example.spring_boot.repository.IProductRepository;
import com.example.spring_boot.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }

    public void save(Product product){
        iProductRepository.save(product);
    }

    @Override
    public Product findById(Long id) throws ProductNotFoundException {
        return iProductRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
    }

}
