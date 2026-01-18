package com.sudhan.ProductService.Services;

import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Category;
import com.sudhan.ProductService.Models.Product;
import com.sudhan.ProductService.Repositories.CategoryRepository;
import com.sudhan.ProductService.Repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public SelfProductService(
      ProductRepository productRepository, CategoryRepository categoryRepository) {
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getSingleProduct(Long productId) throws ProductNotFoundException {
    Optional<Product> optionalProduct = productRepository.findById(productId);

    if (optionalProduct.isEmpty()) {
      throw new ProductNotFoundException(productId);
    }

    return optionalProduct.get();
  }

  @Override
  public Product createProduct(Product product) {

    Category category = product.getCategory();

    Optional<Category> optionalCategory = categoryRepository.findByTitle(category.getTitle());

    if (optionalCategory.isEmpty()) {
      // Create a category
      Category savedCategory = categoryRepository.save(category);
      product.setCategory(savedCategory);
    } else {
      product.setCategory(optionalCategory.get());
    }
    return productRepository.save(product);
  }

  @Override
  public Product replaceProduct(Long productId, Product product) {
    return null;
  }
}
