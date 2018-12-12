package com.frame.web;

import java.util.concurrent.CountDownLatch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.core.KafkaTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@MapperScan("com.frame.dao")
@ComponentScan(basePackages = {"com.frame"})
public class FrameApplication implements CommandLineRunner{

	
	public static void main(String[] args) {	
		log.info("spring初始化开始");
		SpringApplication.run(FrameApplication.class, args);
		log.info("spring初始化结束");
	}
	
	
	 @Autowired
	   private KafkaTemplate<String, String> template;
	 
	   private final CountDownLatch latch = new CountDownLatch(4);
	 
	   @Override
	   public void run(String... args) throws Exception {
	      this.template.send("myTopic", "foo1");
	      this.template.send("myTopic", "foo2");
	      this.template.send("myTopic", "foo3");
	      this.template.send("myTopic", "hi", "foo4");
	      this.template.send("myTopic2", "2", "foo5");
	   }
}
