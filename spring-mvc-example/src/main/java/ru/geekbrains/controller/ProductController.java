package ru.geekbrains.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/product")
@Controller
public class ProductController {

    @GetMapping
    public String  productList() {
        return "products";
    }

    @GetMapping("create")
    public String createProduct() {
        return "product";
    }

    @PostMapping
    public String  saveProduct() {
        return "redirect:/product";
    }

}
