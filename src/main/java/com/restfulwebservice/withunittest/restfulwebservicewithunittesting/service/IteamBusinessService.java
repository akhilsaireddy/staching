package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.service;

import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.data.ItemRepository;
import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IteamBusinessService {

    @Autowired
    private ItemRepository itemRepository;

    public Item retriveHardCodedItem(){
        return new Item(1, "Ball" , 10, 100);
    }

    public List<Item> retriveAllItems() {
        List<Item> items = itemRepository.findAll();
        for (Item item: items){
            item.setValue(item.getPrice() * item.getQuantity());
        }
        return items;
    }
}
