package com.example.POS_System.repository;

import com.example.POS_System.model.Item;
import com.example.POS_System.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByItem(Item item);
}


