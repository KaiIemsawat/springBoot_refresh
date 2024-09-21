package com.kai.springboot_rest_crud.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestControllerDemo {

    // add code for endpoint
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
