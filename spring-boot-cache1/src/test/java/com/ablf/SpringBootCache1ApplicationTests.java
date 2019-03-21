package com.ablf;

import com.ablf.entity.Employee;
import com.ablf.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootCache1ApplicationTests {

	@Autowired
	EmployeeMapper employeeMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

	@Autowired
	RedisTemplate empRedisTemplate;

	@Autowired
	RedisTemplate allRedisTemplate;

	@Test
	public void contextLoads() {

		Employee employee = employeeMapper.getEmpById(1);
        System.out.println(employee);
    }

    @Test
    public void redisTest(){
//		stringRedisTemplate.opsForValue().append("msg","hello");

		/*String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);*/

		stringRedisTemplate.opsForList().leftPush("list","1");
		stringRedisTemplate.opsForList().leftPush("list","2");
		stringRedisTemplate.opsForList().leftPush("list","3");

		String list = stringRedisTemplate.opsForList().leftPop("list");
		System.out.println(list);
	}

	@Test
	public void redisTest2(){
		Employee employee = employeeMapper.getEmpById(1);
		//redisTemplate.opsForValue().set("emp",employee);

		//使用自己写的redisTemplate,序列化器用json的
//		empRedisTemplate.opsForValue().set("empJsom",employee);
		//redisTemplate.delete("emp");

		allRedisTemplate.opsForValue().set("empJsom",employee);


	}

}
