package com.hwmo.app.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    /***
     * 实例化Queue对象，指定消息队列的名称，创建队列对象
     */
    @Bean
    public Queue queue(){
        return new Queue("mhw-queue");
    }
}
