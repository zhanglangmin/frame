package com.frame.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * @author zhanglm
 * @date 2018年11月22日 上午11:06:46
 * 
 */
public class MainConfig {
//	@Bean
//	public ResourceBundleMessageSource messageSource(){
//	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//	    messageSource.setBasenames("messages","messages");
//	    messageSource.setDefaultEncoding("UTF-8");
//	    messageSource.setCacheSeconds(1);
//	    return messageSource;
//	}
	
//	@Configuration
//	@EnableKafka
//	public class KafkaConfig {
//	//topic config Topic的配置开始
//	    @Bean
//	    public KafkaAdmin admin() {
//	        Map<String, Object> configs = new HashMap<String, Object>();
//	        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.180.128:9092");
//	        return new KafkaAdmin(configs);
//	    }
//
//	    @Bean
//	    public NewTopic topic1() {
//	        return new NewTopic("foo", 10, (short) 2);
//	    }
//	//topic的配置结束
//
//	}
}
