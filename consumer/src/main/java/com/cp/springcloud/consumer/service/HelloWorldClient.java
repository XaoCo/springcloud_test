package com.cp.springcloud.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther CPP
 * @date 2020/5/19 17:10
 */

@Configuration
@EnableFeignClients
@EnableDiscoveryClient
public class HelloWorldClient {
    @Autowired
    private TheClient theClient;

    @FeignClient(url = "192.168.126.10:8081",name = "qqq")
    interface TheClient {

        @RequestMapping(path = "/helloworld", method = RequestMethod.GET)
        @ResponseBody
        String HelloWorld();

        @RequestMapping(path = "/findAll", method = RequestMethod.GET)
        @ResponseBody
        List<String> findAll();
    }

    public String HelloWorld() {
        return theClient.HelloWorld();
    }

    public List<String> findAll() {
        return theClient.findAll();
    }
}
