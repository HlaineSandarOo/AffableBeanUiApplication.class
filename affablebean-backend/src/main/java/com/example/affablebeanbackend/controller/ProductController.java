package com.example.affablebeanbackend.controller;

import com.example.affablebeanbackend.dto.ProductDto;
import com.example.affablebeanbackend.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public List<ProductDto> findAllProducts() {
        return productService.findAllProduct();
    }
}
