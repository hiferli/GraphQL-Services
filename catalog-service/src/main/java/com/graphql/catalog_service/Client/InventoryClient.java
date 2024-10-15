package com.graphql.catalog_service.Client;

import com.graphql.catalog_service.DTO.Item;
import com.graphql.catalog_service.DTO.ItemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.net.http.HttpClient;
import java.util.List;

@Component
public class InventoryClient {
    @Autowired
    private HttpGraphQlClient graphQlClient;

    public List<Item> viewProducts() {
        String graphQLQuery = """
                query GetProducts {
                    getProducts {
                        name
                        price
                    }
                }
                """;

        return graphQlClient
                .document(graphQLQuery)
                .retrieve("getProducts")
                .toEntityList(Item.class).block();
    }

    public List<Item> viewProductsByCategory(String category) {
        String graphQLQuery = String.format(
                """     
                query GetProductsByCategory {
                    getProductsByCategory(category: "%s") {
                        name
                        category
                        price
                        stock
                    }
                }
                """ , category);

        return graphQlClient.document(graphQLQuery)
                .retrieve("getProductsByCategory")
                .toEntityList(Item.class).block();
    }

    public Item newConsignment(ItemRequestDTO itemRequestDTO) {
        String graphQLQuery = String.format(
                """
                mutation NewConsignment {
                    newConsignment(id: \"%s\", quantity: %d) {
                        name
                        price
                        stock
                    }
                }
                """ , itemRequestDTO.getId() , itemRequestDTO.getQuantity());

        return graphQlClient
                .document(graphQLQuery)
                .retrieve("newConsignment")
                .toEntity(Item.class).block();
    }
}
