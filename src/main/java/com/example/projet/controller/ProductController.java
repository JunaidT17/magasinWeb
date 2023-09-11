package com.example.projet.controller;

import com.example.projet.entity.Product;
import com.example.projet.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @GetMapping(value ="/products")
    public String viewProductList(Model model) {
        model.addAttribute("productlist", productService.getAllProduct());
        return "product";
    }
    @GetMapping(value = "/addnew")
    public String addNewProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "addProduct";
    }

    @PostMapping(value = "/products/save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.createProduct(product);
        return "product";
    }

    @GetMapping(value = "/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "updatedProduct";
    }


    @GetMapping(value ="/deleteProduct/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        productService.deleteProduct(id);
        return "product";

    }

}
