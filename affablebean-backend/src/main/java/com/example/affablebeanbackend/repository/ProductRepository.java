package com.example.affablebeanbackend.repository;

import com.example.affablebeanbackend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("""
            select p from Product p where  p.category.name = ?1
          """)
    List<Product> allProductsByCategoryName(String name);
}
