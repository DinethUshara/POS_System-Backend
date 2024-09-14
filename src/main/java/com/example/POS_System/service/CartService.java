package com.example.POS_System.service;

import com.example.POS_System.model.CartItem;
import com.example.POS_System.model.Invoice;
import com.example.POS_System.model.Item;
import com.example.POS_System.model.Stock;
import com.example.POS_System.repository.CartItemRepository;
import com.example.POS_System.repository.InvoiceRepository;
import com.example.POS_System.repository.ItemRepository;
import com.example.POS_System.repository.StockRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class CartService {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    public CartItem addItemToCart(Integer itemId, int quantity) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Item not found"));
        Stock stock = stockRepository.findByItem(item);

        if (stock.getQuantity() < quantity) {
            throw new RuntimeException("Not enough stock");
        }

        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);

        return cartItem;
    }

    @Transactional
    public Invoice checkout() {
        Logger logger = Logger.getLogger("CheckoutLogger");
        List<CartItem> cartItems = cartItemRepository.findAll();
        double total = 0;

        for (CartItem cartItem : cartItems) {
            Stock stock = stockRepository.findByItem(cartItem.getItem());
            stock.setQuantity((int) (stock.getQuantity() - cartItem.getQuantity()));
            stockRepository.save(stock);
            logger.info("cartItem $" + cartItem);
            logger.info("cartItem $" + cartItem.getItem().getPrice());
            total += cartItem.getItem().getPrice() * cartItem.getQuantity();
            logger.info("total $" + total);
        }

        Invoice invoice = new Invoice();
//        invoice.setCartItems(cartItems);
//        invoice.setTotal(total);
        invoiceRepository.save(invoice);

        cartItemRepository.deleteAll();

        return invoice;
    }
}