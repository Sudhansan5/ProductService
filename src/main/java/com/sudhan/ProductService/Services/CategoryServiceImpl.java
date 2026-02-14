package com.sudhan.ProductService.Services;

import com.sudhan.ProductService.Exceptions.CategoryNotFoundException;
import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Category;
import com.sudhan.ProductService.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("CategoryService")
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getSingleCategory(Long categoryId) throws CategoryNotFoundException {
        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (categoryOptional.isEmpty()){
            throw new CategoryNotFoundException(categoryId);
        }
            return categoryOptional.get();
    }
}
