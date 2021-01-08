package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.controller;

import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.entity.Item;
import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.service.IteamBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ItemController {

    @Autowired
    private IteamBusinessService iteamBusinessService;

    @RequestMapping("/item")
    public Item dummyItem(){
        return new Item(1, "Ball" , 10, 100);
    }
    @RequestMapping("/itemwithservice")
    public Item dummyItemWithService(){
                return iteamBusinessService.retriveHardCodedItem();
    }
    @GetMapping("/all-items-from-database")
    public List<Item> retriveAllTheItems(){
        return iteamBusinessService.retriveAllItems();
    }


}
