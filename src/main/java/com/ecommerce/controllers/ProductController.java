package com.ecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping("/productCheck")
    public String productHealthCheck(){

        System.out.println("hello msg");
        return "Product Service Working properly";
    }
}
