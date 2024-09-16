package com.kai.quickstart.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerDemo {

    // expose "/", return hello world
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!!";
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run 5k";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is a good day";
    }
}
