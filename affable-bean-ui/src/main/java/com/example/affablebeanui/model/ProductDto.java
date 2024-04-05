package com.example.affablebeanui.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductDto {

    private Integer id;
    private String description;
    private String name;
    private double price;
    private int quantity;
    private String categoryName;
}