package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.data;

import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
