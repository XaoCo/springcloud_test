package com.cp.springcloud.consumer.controller;

import com.cp.springcloud.consumer.service.HelloWorldClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @auther CPP
 * @date 2020/5/19 17:01
 */
@RestController
public class GreetingController {
    @Autowired
    private HelloWorldClient helloWorldClient;

    @GetMapping("/get-greeting")
    public String greeting() {

        return helloWorldClient.HelloWorld();

    }
    @GetMapping("/findAll")
    public List<String> findAll() {

        return helloWorldClient.findAll();

    }
}

