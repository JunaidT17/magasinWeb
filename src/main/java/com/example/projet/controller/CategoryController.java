package com.example.projet.controller;

import com.example.projet.entity.Category;
import com.example.projet.entity.Product;
import com.example.projet.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value ="/categorys")
    public String viewProductList(Model model) {
        model.addAttribute("categorylist", categoryService.getAllCategory());
        return "category";
    }
    @GetMapping(value ="/addnew")
    public String addNewCategory(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "addCategory";
    }

    @PostMapping(value ="/categorys/save")
    public String saveCategory(@ModelAttribute("category") Category category) {
        categoryService.createCategory(category);
        return "category";
    }

    @GetMapping(value ="/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "updatedCategory";
    }


    @GetMapping(value ="/deleteCategory/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        categoryService.deleteCategory(id);
        return "category";

    }

}

