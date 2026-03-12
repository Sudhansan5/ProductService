package com.sudhan.ProductService.Services;

import com.sudhan.ProductService.Exceptions.ProductNotFoundException;
import com.sudhan.ProductService.Models.Category;
import com.sudhan.ProductService.Models.Product;
import com.sudhan.ProductService.Repositories.CategoryRepository;
import com.sudhan.ProductService.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;
  @Autowired
  private RedisTemplate<String,Object> redisTemplate;
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
    String hashKey = "PRODUCT";
    String field = "PRODUCT_" + productId;

    Object cached = redisTemplate.opsForHash().get(hashKey, field);
    if (cached instanceof Product) {
      // cache hit
      return (Product) cached;
    }

    Optional<Product> optionalProduct = productRepository.findById(productId);

    if (optionalProduct.isEmpty()) {
      throw new ProductNotFoundException(productId);
    }

    Product product = optionalProduct.get();
    // Store the Product object under the same hash key and field
    redisTemplate.opsForHash().put(hashKey, field, product);
    return product;
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
