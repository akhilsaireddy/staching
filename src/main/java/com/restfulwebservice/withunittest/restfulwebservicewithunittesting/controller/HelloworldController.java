package com.restfulwebservice.withunittest.restfulwebservicewithunittesting.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class HelloworldController {


    @RequestMapping("/hello")
    public String helloWorld(){
        return "Hello-World";
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("aa", 1);
        map.put("bb", 2);
        map.put("cc", 3);
        map.put("dd", 4);

        String str = "KING";
        System.out.println(str.hashCode());
    }
}
