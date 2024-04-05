package com.example.affablebeanbackend.service;

import com.example.affablebeanbackend.dto.ProductDto;
import com.example.affablebeanbackend.entity.Product;
import com.example.affablebeanbackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> findAllProduct() {
        return productRepository.findAll()
                .stream().map(this::toDto)
                .collect(Collectors.toList());
    }
    private ProductDto toDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getDescription(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getCategory().getName()
        );
    }
}
