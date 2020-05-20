package com.cp.springcloud.provider.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther CPP
 * @date 2020/5/19 16:43
 */
@RestController
public class UserDemoController {
    @GetMapping("/helloworld")
    public String HelloWorld() {
        return "Hello 123456!";
    }

    @GetMapping (value = "/findAll")
    public List<String> findAll(){
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list.add(i+"");
        }
        return list;
    }
}



