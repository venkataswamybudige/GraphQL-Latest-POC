package com.javatechie.controller;


import com.javatechie.dto.Item;
import com.javatechie.dto.ItemRequestDTO;
import com.javatechie.service.CatelogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catelog")
public class CatelogController {

    @Autowired
    private CatelogService catelogService;

    @GetMapping("/products")
    public List<Item> viewProducts() {
        return catelogService.viewProducts();
    }

    @GetMapping("/products/category")
    public List<Item> viewProducts(@RequestParam  String category){
        return  catelogService.viewProducts(category);
    }

    @PostMapping("/shipment")
    public Item recieveNewShipment(@RequestBody  ItemRequestDTO itemRequestDTO) {
        return  catelogService.recieveNewShipment(itemRequestDTO);
    }
}
