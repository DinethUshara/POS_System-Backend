package com.example.POS_System.dto;

import lombok.Getter;

@Getter
public class StockRequest {
    // Getters and setters
    private Integer item_id;
    private int quantity;

    public void setItem_id(Integer item_id) {
        this.item_id = item_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
