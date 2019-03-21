package com.ablf.service;

import com.ablf.entity.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * Created by du on 2019/2/25.
 */
@Service
public class RabbitMqService {

    @RabbitListener(queues = "ablf.news")
    public void getMsgFromMQ(Book book){
        System.out.println("收到消息:"+book);
    }


    /*@RabbitListener(queues = "ablf.emps")
    public void getMsgFromMsg(Message msg){
        System.out.println(msg.getBody());
        System.out.println(msg.getMessageProperties());

    }*/

}
