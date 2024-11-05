package com.javatechie.client;


import com.javatechie.dto.Item;
import com.javatechie.dto.ItemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class InventoryClient {

    @Autowired
    private HttpGraphQlClient graphQLClientConfig;

    public List<Item> viewProducts() {
        String query = "query GetProducts {\n" +
                "    getProducts {\n" +
                "        name\n" +
                "        price\n" +
                "    }\n" +
                "}\n";
         return   graphQLClientConfig.document(query).retrieve("getProducts").toEntityList(Item.class).block();

    }


    public List<Item> viewProducts(String category){
        String graphQlQuery = String.format("query GetProductsByCategory {\n" +
                "    getProductsByCategory(category: \"%s\") {\n" +
                "        name\n" +
                "        category\n" +
                "        price\n" +
                "        stock\n" +
                "    }\n" +
                "}\n",category);
        return   graphQLClientConfig.document(graphQlQuery).retrieve("getProductsByCategory").toEntityList(Item.class).block();

    }

    public Item recieveNewShipment(ItemRequestDTO itemRequestDTO) {

        String query = String.format("mutation RecieveNewShipment {\n" +
                "    recieveNewShipment(id: \"%s\", quantity: %d) {\n" +
                "        name\n" +
                "        price\n" +
                "        stock\n" +
                "    }\n" +
                "}\n",itemRequestDTO.getId(),itemRequestDTO.getQty());

       return graphQLClientConfig.document(query).retrieve("recieveNewShipment").
               toEntity(Item.class).block();


    }

}
