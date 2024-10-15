package com.graphql.catalog_service.Service;

import com.graphql.catalog_service.Client.InventoryClient;
import com.graphql.catalog_service.DTO.Item;
import com.graphql.catalog_service.DTO.ItemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    @Autowired
    private InventoryClient inventoryClient;

    public List<Item> viewProducts() {
        return inventoryClient.viewProducts();
    }

    public List<Item> viewProductsByCategory(String category) {
        return inventoryClient.viewProductsByCategory(category);
    }

    public Item newConsignment(ItemRequestDTO itemRequestDTO) {
        return inventoryClient.newConsignment(itemRequestDTO);
    }
}
