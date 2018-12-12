package com.frame.message;

import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;




/**
 * @author zhanglm
 * @date 2018年12月10日 上午10:16:47
 * 
 */
public class Topic {

	public static void main(String[] args) {
	    //创建topic
	    Properties props = new Properties();
	    props.put("bootstrap.servers", "192.168.180.128:9092");
	    AdminClient adminClient = AdminClient.create(props);
	    ArrayList<NewTopic> topics = new ArrayList<NewTopic>();
	    NewTopic newTopic = new NewTopic("topic-test", 1, (short) 1);
	    topics.add(newTopic);
	    CreateTopicsResult result = adminClient.createTopics(topics);
	    try {
	        result.all().get();
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } catch (ExecutionException e) {
	        e.printStackTrace();
	    }
	}
}
