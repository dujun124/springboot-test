package com.ablf;

import com.ablf.entity.Book;
import com.rabbitmq.client.AMQP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;


	@Test
	public void mqadmin(){
		//amqpAdmin.declareExchange(new DirectExchange("admin.direct"));

		//Queue queue = new Queue("adminQueue",true);
		//amqpAdmin.declareQueue(queue);

		Binding binding = new Binding("adminQueue", Binding.DestinationType.QUEUE, "admin.direct", "admin.haha", null);
		amqpAdmin.declareBinding(binding);



	}


	@Test
	public void contextLoads() {

		Map<String , String > map = new HashMap<>();
		map.put("msg","这是一个消息");
		map.put("qqq","ppp");

		rabbitTemplate.convertAndSend("ablf.direct","ablf.news",map);

	}


	@Test
	public void getMsg(){
		Object o = rabbitTemplate.receiveAndConvert("ablf.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	/**@Test
	public void setBookToMq(){

		rabbitTemplate.convertAndSend("exchange.direct","ablf.news",new Book("book1","120"));
		Object o = rabbitTemplate.receiveAndConvert("ablf.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	@Test
	public void setFanout(){
		rabbitTemplate.convertAndSend("exchange.fanout","",new Book("三国","罗贯中"));
	}
*/
}
