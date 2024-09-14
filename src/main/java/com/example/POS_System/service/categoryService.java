package com.example.POS_System.service;

import com.example.POS_System.model.Category;
import com.example.POS_System.repository.categoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class categoryService {

    @Autowired
    private categoryRepository categoryRepository;

    // Create operation
    public Category addItemCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Read operation
    public List<Category> getAllItemCategories() {
        return categoryRepository.findAll();
    }

    // Read operation
    public Category getItemCategoryById(int id) throws Exception {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Item not found with id: " + id));
    }

    // Update operation
    public Category updateItemCategory(int id, Category category) throws Exception {
        Category existingCategory = getItemCategoryById(id);
        existingCategory.setName(category.getName());
        // Update other fields as needed
        return categoryRepository.save(existingCategory);
    }

    // Delete operation
    public void deleteItemCategory(int id) {
        categoryRepository.deleteById(id);
    }
}