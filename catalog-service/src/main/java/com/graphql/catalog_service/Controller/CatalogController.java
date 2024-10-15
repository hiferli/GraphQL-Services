package com.graphql.catalog_service.Controller;

import com.graphql.catalog_service.DTO.Item;
import com.graphql.catalog_service.DTO.ItemRequestDTO;
import com.graphql.catalog_service.Service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    @GetMapping("/products")
    public List<Item> viewProducts() {
        return catalogService.viewProducts();
    }

    @GetMapping("/products/category")
    public List<Item> viewProductsByCategory(@RequestParam String category) {
        return catalogService.viewProductsByCategory(category);
    }

    @PostMapping("/shipment")
    public Item newConsignment(@RequestBody ItemRequestDTO itemRequestDTO) {
        return catalogService.newConsignment(itemRequestDTO);
    }
}
