package com.kai.springCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice fast swing...!!!";
    }
}
