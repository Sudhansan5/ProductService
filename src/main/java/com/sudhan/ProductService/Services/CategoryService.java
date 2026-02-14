package com.sudhan.ProductService.Services;

import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Category;
import com.sudhan.ProductService.Models.Product;

public interface CategoryService {
    Category getSingleCategory(Long categoryId) throws ProductNotFoundException;
}
