package com.example.projet.service;

import com.example.projet.entity.Category;
import com.example.projet.entity.Product;
import com.example.projet.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }


    public Category getCategoryById(Long categoryId) {
        Optional<Category> optionalCategory = categoryRepository.findById(categoryId);
        return optionalCategory.get();
    }

    public List<Category> findCategoryByName(String name) {
        return categoryRepository.findProductByName(name);
    }


    public Category updateCategory(Long id,Category category) {
        Category existingCategory = categoryRepository.findById(category.getId()).get();
        existingCategory.setName(category.getName());
        Category updatedCategory = categoryRepository.save(existingCategory);
        return updatedCategory;
    }


    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}
