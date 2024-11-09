package com.example.spring_boot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ProductAOP {
    @Pointcut("execution(* com.example.spring_boot.controller.ProductController.*(..))")
    public void createPointCutOfShowCreateForm(){

    }
    @Before("createPointCutOfShowCreateForm()")
    public void beforeClickShowCreateButton(JoinPoint joinPoint){
        System.out.println("Before: " + joinPoint.getSignature().getName());
        // get current time
    }

    @After("createPointCutOfShowCreateForm()")
    public void afterSaveCreateForm(JoinPoint joinPoint){
        System.out.println("After: " + joinPoint.getSignature().getName());
        // get current time
    }
}
