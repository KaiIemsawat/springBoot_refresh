package com.kai.springCoreDemo.rest;

import com.kai.springCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for the dependencies
    private Coach myCoach;
    private Coach anotherCoach;

    @Autowired
    public DemoController(
            // Default scope is singleton, all dependency injections for the bean will reference the same bean
            @Qualifier("cricketCoach") Coach theCoach, @Qualifier("cricketCoach") Coach theOtherCoach
    ) {
        System.out.println("In constructor " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCoach = theOtherCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check() {
        return "Comparing beans : myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
