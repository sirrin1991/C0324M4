package com.example.spring_boot.controller;

import com.example.spring_boot.common.ProductNotFoundException;
import com.example.spring_boot.model.Category;
import com.example.spring_boot.model.Product;
import com.example.spring_boot.model.ProductDTO;
import com.example.spring_boot.service.ICategoryService;
import com.example.spring_boot.service.IProductService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@SessionAttributes("categories")
@RequestMapping("/")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categories")
    public List<Category> getCategories() {
        return  iCategoryService.findAll();
    }
    
    @GetMapping
    public String showList(Model model,
                           @RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page, 3, sort);
        Page<Product> products = iProductService.findAll(pageable);
        model.addAttribute("list", products);
        return "home";
//        return  null;
    }

    @GetMapping("show-create-from")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new ProductDTO());
        return "create_form";
    }

    @PostMapping("save")
    public String save(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult, Model model) {

        new ProductDTO().validate(productDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            return "create_form";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        iProductService.save(product);
        return "redirect:/";
    }

    
}
