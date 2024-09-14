package com.example.POS_System.repository;

import com.example.POS_System.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface categoryRepository extends JpaRepository<Category, Integer> {
}
