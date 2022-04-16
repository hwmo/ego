package com.hwmo.app.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {

    @Bean
    public Logger.Level getLog(){
        return Logger.Level.FULL;
    }

    //feign重试机制
    @Bean
    public Retryer rectryer(){
        return new Retryer.Default();
    }
}
