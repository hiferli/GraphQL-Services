package com.graphql.inventory_service;

import com.graphql.inventory_service.Entities.Product;
import com.graphql.inventory_service.Repositories.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class InventoryServiceApplication {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

//    @PostConstruct
//    private void initDatabase() {
//        List<Product> products = Stream.of(
//                new Product("Laptop", "Electronics", 999.99f, 10),
//                new Product("Coffee Maker", "Home Appliances", 49.99f, 25),
//                new Product("Running Shoes", "Footwear", 75.50f, 50),
//                new Product("Bluetooth Headphones", "Electronics", 199.99f, 15),
//                new Product("Water Bottle", "Sports", 12.99f, 100),
//                new Product("Desk Chair", "Furniture", 149.99f, 8),
//                new Product("T-Shirt", "Clothing", 19.99f, 200)
//        ).collect(Collectors.toList());
//
//        productRepository.saveAll(products);
//    }

}
