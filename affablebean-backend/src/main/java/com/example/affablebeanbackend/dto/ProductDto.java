package com.example.affablebeanbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDto {

    private Integer id;
    private String description;
    private String name;
    private double price;
    private int quantity;
    private String categoryName;
}
