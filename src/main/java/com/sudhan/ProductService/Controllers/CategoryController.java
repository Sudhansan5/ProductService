package com.sudhan.ProductService.Controllers;


import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Category;
import com.sudhan.ProductService.Services.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId) throws ProductNotFoundException {
        return categoryService.getSingleCategory(categoryId);
    }
}
