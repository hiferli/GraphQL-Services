package com.graphql.inventory_service.Repositories;

import com.graphql.inventory_service.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product , Integer> {
    List<Product> findByCategory(String category);
}
