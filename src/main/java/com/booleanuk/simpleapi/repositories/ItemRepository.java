package com.booleanuk.simpleapi.repositories;

import com.booleanuk.simpleapi.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
