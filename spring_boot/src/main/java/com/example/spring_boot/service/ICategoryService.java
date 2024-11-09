package com.example.spring_boot.service;

import com.example.spring_boot.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
