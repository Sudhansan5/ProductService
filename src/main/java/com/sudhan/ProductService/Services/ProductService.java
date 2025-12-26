package com.sudhan.ProductService.Services;

import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getSingleProduct(Long productId) throws ProductNotFoundException;

    Product createProduct(Product product);

    Product replaceProduct(Long productId, Product product);
}
