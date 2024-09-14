package com.example.POS_System.controller;

import com.example.POS_System.model.CartItem;
import com.example.POS_System.model.Invoice;
import com.example.POS_System.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/add")
    public CartItem addItemToCart(@RequestParam Integer itemId, @RequestParam int quantity) {
        return cartService.addItemToCart(itemId, quantity);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/checkout")
    public Invoice checkout() {
        return cartService.checkout();
    }
}