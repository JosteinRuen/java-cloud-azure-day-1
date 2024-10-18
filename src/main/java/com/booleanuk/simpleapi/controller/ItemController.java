package com.booleanuk.simpleapi.controller;

import com.booleanuk.simpleapi.model.Item;
import com.booleanuk.simpleapi.repositories.ItemRepository;
import com.booleanuk.simpleapi.response.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public Item getItemById(@PathVariable int id) {
        return this.itemRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No item with that ID found")
        );
    }

    @PostMapping
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        return new ResponseEntity<>(this.itemRepository.save(item), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item) {
        Item itemToUpdate = this.itemRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No item with that ID found")
        );
        itemToUpdate.setDescription(item.getDescription());
        itemToUpdate.setPrice(item.getPrice());
        itemToUpdate.setQuantity(item.getQuantity());
        return new ResponseEntity<>(this.itemRepository.save(itemToUpdate), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Item> deleteItem(@PathVariable int id) {
        Item itemToDelete = this.itemRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No item with that ID found")
        );
        this.itemRepository.delete(itemToDelete);
        return ResponseEntity.ok(itemToDelete);
    }
}
