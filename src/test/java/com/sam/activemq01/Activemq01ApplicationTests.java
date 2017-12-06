package com.sam.activemq01;

import com.sam.activemq01.jms.Producer;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jms.Destination;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Activemq01ApplicationTests {

    @Autowired
    private Producer producer;

    @Test
    public void contextLoads() {
        try {
            Destination destination = new ActiveMQQueue("mytest.queue");
            for (int i = 0; i < 20; i++) {
                producer.sendMessage(destination, "This is " + i + " message , got it!");
                Thread.currentThread().sleep(2000);//毫秒
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
