package com.ablf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(value = "com.ablf.mapper")
@SpringBootApplication
@EnableCaching//开启基于注解的缓存
public class SpringBootCache1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCache1Application.class, args);
	}

}
