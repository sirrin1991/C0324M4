package com.example.spring_boot.controller;

import com.example.spring_boot.common.ProductNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandle {
//    @ExceptionHandler(Exception.class)
//    public String handleGlobalException(){
//        return "handle_global_exception.html";
//    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleProductNotFoundException(){
        return "not_found";
    }
}
