package com.javatechie.service;

import com.javatechie.client.InventoryClient;
import com.javatechie.dto.Item;
import com.javatechie.dto.ItemRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatelogService {

    @Autowired
    private InventoryClient inventoryClient;

    public List<Item> viewProducts() {
       return inventoryClient.viewProducts();
    }

    public List<Item> viewProducts(String category){
        return  inventoryClient.viewProducts(category);
    }

    public Item recieveNewShipment(ItemRequestDTO itemRequestDTO) {
        return  inventoryClient.recieveNewShipment(itemRequestDTO);
    }

}
