package com.example.POS_System.service;

import com.example.POS_System.dto.ItemRequest;
import com.example.POS_System.model.Category;
import com.example.POS_System.model.Item;
import com.example.POS_System.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private com.example.POS_System.repository.categoryRepository categoryRepository;

    // Create operation
    public Item addItem(ItemRequest itemRequest) throws Exception {
        Logger logger = Logger.getLogger("CheckoutLogger");
        logger.info("itemRequest $" + itemRequest.getCategoryId());
        Category category = categoryRepository.findById(itemRequest.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found with id: "));

        Item item = new Item();
        item.setCategory(category);
        item.setName(itemRequest.getName());
        item.setPrice(itemRequest.getPrice());
        return itemRepository.save(item);
    }

    // Read operation
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Read operation
    public Item getItemById(int id) throws Exception {
        return itemRepository.findById(id)
                .orElseThrow(() -> new Exception("Item not found with id: " + id));
    }

    // Update operation
    public Item updateItem(int id,ItemRequest itemRequest ) throws Exception {
        Item existingItem = getItemById(id);
        Category category = categoryRepository.findById(itemRequest.getCategoryId())
                .orElseThrow(() -> new Exception("Category not found with id: " ));
        existingItem.setCategory(category);
        existingItem.setName(itemRequest.getName());
        existingItem.setPrice(itemRequest.getPrice());

        return itemRepository.save(existingItem);
    }

    // Delete operation
    public void deleteItem(int id) {
        itemRepository.deleteById(id);
    }
}
