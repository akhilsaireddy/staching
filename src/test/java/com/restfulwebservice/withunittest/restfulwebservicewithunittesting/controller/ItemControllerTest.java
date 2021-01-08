package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.controller;

import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.entity.Item;
import com.restfulwebservice.withunittest.restfulwebservicewithunittesting.service.IteamBusinessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private IteamBusinessService iteamBusinessService;

    @Test
    public void dummyItem() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }
    @Test
    public void dummyItemWithService() throws Exception{
        when(iteamBusinessService.retriveHardCodedItem()).thenReturn(new Item(2,"Ball",10,100));
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/itemwithservice")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                .andReturn();
    }

    @Test
    public void retriveAllTheItems() throws Exception {
        when(iteamBusinessService.retriveAllItems()).thenReturn(Arrays.asList(new Item(1001,"item 1",10,20),
                new Item(1002,"item 2",20,20),
                new Item(1003,"item 3",30,30),
                new Item(1004,"item 4",40,40),
                new Item(1005,"item 5",50,50)));
        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(request)
                .andExpect(content().json("[{\"id\":1001,\"name\":\"item 1\",\"price\":10,\"quantity\":20}," +
                        "{\"id\":1002,\"name\":\"item 2\",\"price\":20,\"quantity\":20}," +
                        "{\"id\":1003,\"name\":\"item 3\",\"price\":30,\"quantity\":30}," +
                        "{\"id\":1004,\"name\":\"item 4\",\"price\":40,\"quantity\":40}," +
                        "{\"id\":1005,\"name\":\"item 5\",\"price\":50,\"quantity\":50}]"))
                .andExpect(status().isOk())
                .andReturn();
    }
}
