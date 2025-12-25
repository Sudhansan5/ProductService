package com.sudhan.ProductService.Services;

import com.sudhan.ProductService.DTOs.FakeStoreProductDto;
import com.sudhan.ProductService.Models.Category;
import com.sudhan.ProductService.Models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {
  private final RestTemplate restTemplate;

  public FakeStoreProductService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public List<Product> getAllProducts() {
    // TODO: HW
    return null;
  }

  @Override
  public Product getSingleProduct(Long productId) {

    ResponseEntity<FakeStoreProductDto> responseEntity =
        restTemplate.getForEntity(
            "https://fakestoreapi.com/products/" + productId, FakeStoreProductDto.class);

    return convertFakeStoreProductDtoToProduct(responseEntity.getBody());
  }

  @Override
  public Product createProduct(Product product) {
    return null;
  }

  @Override
  public Product replaceProduct(Long productId, Product product) {
    return null;
  }

  private Product convertFakeStoreProductDtoToProduct(FakeStoreProductDto fakeStoreProductDto) {
    if (fakeStoreProductDto == null) {
      return null;
    }

    Product product = new Product();
    product.setTitle(fakeStoreProductDto.getTitle());
    product.setDescription(fakeStoreProductDto.getDescription());
    product.setPrice(fakeStoreProductDto.getPrice());
    product.setImageUrl(fakeStoreProductDto.getImage());
    Category category = new Category();
    category.setTitle(fakeStoreProductDto.getCategory());
    product.setCategory(category);
    product.setId(fakeStoreProductDto.getId());

    return product;
  }
}
