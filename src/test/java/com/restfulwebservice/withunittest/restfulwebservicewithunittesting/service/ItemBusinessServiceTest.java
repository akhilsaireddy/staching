package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.service;

import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.data.ItemRepository;
import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.entity.Item;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(IteamBusinessService.class)
public class ItemBusinessServiceTest {

    @InjectMocks
    private IteamBusinessService iteamBusinessService;

    @Mock
    private ItemRepository repository;

    @Test
    public void retriveAllItems_Logic(){
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Item(1001,"item 1",10,20),
                new Item(1002,"item 2",20,20),
                new Item(1003,"item 3",30,30),
                new Item(1004,"item 4",40,40),
                new Item(1005,"item 5",50,50)));
        List<Item> items = iteamBusinessService.retriveAllItems();
        assertEquals(400,items.get(0).getValue());
    }
}
