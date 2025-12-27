package com.sudhan.ProductService.Controllers;

import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Product;
import com.sudhan.ProductService.Services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private ProductService productService;

  public ProductController(@Qualifier("selfProductService") ProductService productService) {
    this.productService = productService;
  }

  // localhost:8080/products/1
  @GetMapping("/{productId}")
  public Product getSingleProduct(@PathVariable("productId") Long productId)
      throws ProductNotFoundException {
    return productService.getSingleProduct(productId);
  }

  // localhost:8080/products
  @GetMapping()
  public List<Product> getAllProducts() {
    return productService.getAllProducts();
  }

  // localhost:8080/products
  @PostMapping()
  public Product createProduct(@RequestBody Product product) {
    return productService.createProduct(product);
  }

  @PutMapping("/{id}")
  public Product replaceProduct(@PathVariable("id") Long productId, @RequestBody Product product) {
    return null;
  }
}
