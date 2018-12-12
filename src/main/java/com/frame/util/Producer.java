package com.frame.util;

import java.util.concurrent.ExecutionException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author zhanglm
 * @date 2018年12月10日 上午11:06:07
 * 
 */
public class Producer {

	//使用spring-kafka的template发送一条消息 发送多条消息只需要循环多次即可
	public static void main(String[] args) throws ExecutionException, InterruptedException {
	    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(KafkaConfig.class);
	    KafkaTemplate<Integer, String> kafkaTemplate = (KafkaTemplate<Integer, String>) ctx.getBean("kafkaTemplate");
	        String data="this is a test message";
	        ListenableFuture<SendResult<Integer, String>> send = kafkaTemplate.send("topic-test", 1, data);
	        send.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
	            public void onFailure(Throwable throwable) {

	            }

	            public void onSuccess(SendResult<Integer, String> integerStringSendResult) {

	            }
	        });
	}
}
