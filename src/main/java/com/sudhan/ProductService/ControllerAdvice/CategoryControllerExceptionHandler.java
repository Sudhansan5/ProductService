package com.sudhan.ProductService.ControllerAdvice;

import com.sudhan.ProductService.Exceptions.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CategoryControllerExceptionHandler {
@ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFoundException(CategoryNotFoundException categoryNotFoundException){
        return new ResponseEntity<>(categoryNotFoundException.getCategoryId()+" is not a valid category id", HttpStatus.NOT_FOUND);

    }
}
