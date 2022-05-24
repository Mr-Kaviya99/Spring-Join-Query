package com.example.joinquery.repo;

import com.example.joinquery.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ItemRepo extends JpaRepository<Item, String> {
}
