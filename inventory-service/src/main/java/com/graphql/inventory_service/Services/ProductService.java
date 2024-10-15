package com.graphql.inventory_service.Services;

import com.graphql.inventory_service.Entities.Product;
import com.graphql.inventory_service.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public Product updateProduct(Integer id , Integer quantity) {
        Product currentProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found. (For ID: " + id + ")"));

        currentProduct.setStock(quantity);
        return productRepository.save(currentProduct);
    }

    public Product newConsignment(Integer id , Integer quantity) {
        Product currentProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found. (For ID: " + id + ")"));

        currentProduct.setStock(quantity + currentProduct.getStock());
        return productRepository.save(currentProduct);
    }
}
