package com.sudhan.ProductService.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryNotFoundException extends Exception{
    private long categoryId;

    public CategoryNotFoundException(long categoryId) {
        this.categoryId = categoryId;
    }
}
