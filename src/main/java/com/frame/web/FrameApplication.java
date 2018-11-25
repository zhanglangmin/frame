package com.frame.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@MapperScan("com.frame.dao")
@ComponentScan(basePackages = {"com.frame"})
public class FrameApplication {

	
	public static void main(String[] args) {	
		log.info("spring初始化开始");
		SpringApplication.run(FrameApplication.class, args);
		log.info("spring初始化结束");
	}
}
