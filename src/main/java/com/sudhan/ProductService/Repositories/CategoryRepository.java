package com.sudhan.ProductService.Repositories;

import com.sudhan.ProductService.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findByTitle(String title);

  Category save(Category category);
}
