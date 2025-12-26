package com.sudhan.ProductService.Controllers;


import com.sudhan.ProductService.Models.Category;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long categoryId) {
        throw new RuntimeException();
    }
}
