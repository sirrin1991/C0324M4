package com.example.demo.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
@RequestMapping("/")
public class Login {
    @GetMapping("set-cookie")
    public String setCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("name","abc");
        response.addCookie(cookie);
        return null;
    }

    @GetMapping("get-cookie")
    public String getCookie(@CookieValue (name = "name") String name) {
        System.out.println(name);
        return null;
    }
}
