package com.hwmo.app.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendServiceImpl implements SendService {

    @Autowired//注入消息队列操作对象
    private AmqpTemplate template;

    @Override
    public void sendMsg(String msg) {
        template.convertAndSend("mhw-queue", msg);//交消息发送到消息队列中
    }
}
