package com.booleanuk.simpleapi.controller;

import com.booleanuk.simpleapi.model.Item;
import com.booleanuk.simpleapi.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("items")
public class ItemController {
    @Autowired
    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return this.itemRepository.findAll();
    }
}
