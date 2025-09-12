package com.ecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/api/v1/product/productCheck")
    public String productHealthCheck(){

        System.out.println("hello msg45");
        return "Product Service Working properly";
    }
}
