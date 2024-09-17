package com.kai.springCoreDemo.config;

import com.kai.springCoreDemo.common.Coach;
import com.kai.springCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // declare @Bean instead of using @Component
    @Bean("aquatic") // Bean id is optional. By default, use methodName
//    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
