package com.kai.springCoreDemo.common;

import org.springframework.stereotype.Component;

//@Component // instead of using '@Component', use Config file as in SportConfig
public class SwimCoach implements Coach{

    public SwimCoach() {
        System.out.println("In constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim, go swim..!";
    }
}
