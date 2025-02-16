package com.implementations.designpatterns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SingletonConfig {

    private static SingletonConfig instance;

    private SingletonConfig() {}

    public static SingletonConfig getInstance() {
        if (instance == null) {
            instance = new SingletonConfig();
        }
        return instance;
    }

    @Bean
    public SingletonConfig singletonService() {
        return new SingletonConfig();
    }
}
