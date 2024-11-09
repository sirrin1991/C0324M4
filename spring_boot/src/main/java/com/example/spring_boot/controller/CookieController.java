package com.example.spring_boot.controller;

import com.example.spring_boot.model.Category;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cookie/")
public class CookieController {
    @GetMapping
    public void cookie(@ModelAttribute(name = "categories") List<Category> categories) {
        System.out.println(categories);
    }
}
