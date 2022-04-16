package com.hwmo.app;

import com.hwmo.app.service.SendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqProviderApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	public SendService sendService;


	@Test
	public void sendMsg(){

		int index = 1;
		while (true){
		    String msg = "hello! 我是消息"+index;
            System.out.println("开始发送消息："+msg);
			sendService.sendMsg(msg);
			index++;
			try {
				Thread.sleep(2000);
			} catch (Exception e){
				e.printStackTrace();
			}
		}
	}
}
