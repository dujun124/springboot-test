package com.ablf.config;

import com.ablf.entity.Department;
import com.ablf.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by du on 2019/2/22.
 */
@Configuration
public class MyRedisConfig {


    @Bean
    public RedisTemplate<Object, Employee> empRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Employee> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<Employee>(Employee.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

   @Bean
   @Primary
   public RedisCacheManager empRedisCacheManager(RedisTemplate<Object, Employee> empRedisTemplate){
       RedisCacheManager manager = new RedisCacheManager(empRedisTemplate);
       manager.setUsePrefix(true);


       return manager;
   }


    @Bean
    public RedisTemplate<Object, Department> deptRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException {
        RedisTemplate<Object, Department> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer<Department>(Department.class);
        template.setDefaultSerializer(serializer);
        return template;
    }

    @Bean
    public RedisCacheManager deptRedisCacheManager(RedisTemplate<Object, Department> deptRedisTemplate){
        RedisCacheManager manager = new RedisCacheManager(deptRedisTemplate);
        manager.setUsePrefix(true);
        return manager;
    }


}
