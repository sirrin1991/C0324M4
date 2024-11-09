package com.example.spring_boot.repository;

import com.example.spring_boot.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Page: phù hợp cho các DB trung bình và nhỏ
//Slice: phù hợp cho DB lớn

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
//    Page<Product> findAll(Pageable pageable);
}
