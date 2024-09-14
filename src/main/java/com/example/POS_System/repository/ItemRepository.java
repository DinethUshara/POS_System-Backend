package com.example.POS_System.repository;

import com.example.POS_System.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

// ItemRepository.java
public interface ItemRepository extends JpaRepository<Item, Integer> {
}
