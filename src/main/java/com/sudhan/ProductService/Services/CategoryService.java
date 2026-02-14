package com.sudhan.ProductService.Services;

import com.sudhan.ProductService.Exceptions.CategoryNotFoundException;
import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Category;

public interface CategoryService {
    Category getSingleCategory(Long categoryId) throws CategoryNotFoundException;
}
