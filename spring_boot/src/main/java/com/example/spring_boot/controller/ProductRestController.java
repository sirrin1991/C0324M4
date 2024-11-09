package com.example.spring_boot.controller;

import com.example.spring_boot.model.Category;
import com.example.spring_boot.model.Product;
import com.example.spring_boot.model.ProductDTO;
import com.example.spring_boot.service.ICategoryService;
import com.example.spring_boot.service.IProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/")
public class ProductRestController {

//    @Autowired
//    private IProductService iProductService;
//
//    @Autowired
//    private ICategoryService iCategoryService;
//
//    @GetMapping("show-list")
//    public ResponseEntity<List<Product>> showList(Model model,
//                                                  @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
//        Sort sort = Sort.by("name").descending();
//        Pageable pageable = PageRequest.of(page, 3, sort);
//        List<Product> products = iProductService.findAll(pageable);
//        model.addAttribute("list", products);
//        return new ResponseEntity<>(products, HttpStatus.OK);
//    }


//    @PostMapping("save")
//    public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
//
//    }

}
