package com.example.affablebeanbackend.repository;

import com.example.affablebeanbackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
