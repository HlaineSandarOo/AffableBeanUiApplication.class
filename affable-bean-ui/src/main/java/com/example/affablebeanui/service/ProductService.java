package com.example.affablebeanui.service;

import com.example.affablebeanui.model.CartItem;
import com.example.affablebeanui.model.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private RestClient restClient;
    private List<ProductDto> products;

    public List<ProductDto> listProductsByCategoryName(String categoryName) {
        return products.stream()
                .filter(p -> p.getCategoryName().equals(categoryName))
                .collect(Collectors.toList());
    }
    public ProductDto findProductDtoById(int id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException(id + " not found!"));
    }
    public CartItem toCartItem(ProductDto productDto) {
        return new CartItem(
                productDto.getId(),
                productDto.getDescription(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQuantity(),
                false,
                productDto.getCategoryName(),
                Collections.emptyList()
        );
    }

    public ProductService() {
        products = new ArrayList<>();
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8090/api")
                .build();
        getAllProducts();
    }
    public String makeTransaction(String accountNumber, double totalCharge) {
        restClient = RestClient.builder()
                .baseUrl("http://localhost:8070/account")
                .build();
        /*
        http://localhost:8070/account/transaction?ownerAccountNumber=SHWE148815&customerAccountNumber=SHWE176936&amount=40
         */
        String responseString = restClient.post()
                .uri(uriBuilder ->
                    uriBuilder.path("/transaction")
                            .queryParam("ownerAccountNumber", "SHWE148815")
                            .queryParam("customerAccountNumber", accountNumber)
                            .queryParam("amount", totalCharge)
                            .build()
                )
                .contentType(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(String.class);
        System.out.println(responseString);
        return responseString;
    }
    public void getAllProducts() {
        this.products = restClient.get()
                .uri("/products")
                .retrieve()
                .body(new ParameterizedTypeReference<List<ProductDto>>() {
                });
    }

}
