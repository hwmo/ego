package com.hwmo.app.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class ReceiverServiceImpl implements ReceiverService {

    @RabbitListener(queues = {"mhw-queue"})
    @Override
    public void receiverMsg(String msg) {

        System.out.println("接收到的消息是：" + msg);
    }
}
