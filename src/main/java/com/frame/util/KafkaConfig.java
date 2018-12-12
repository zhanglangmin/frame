package com.frame.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhanglm
 * @date 2018年12月10日 上午11:02:46
 * 
 */
@Configuration
@EnableKafka
@Data
@Slf4j
public class KafkaConfig {
    @Value("${bootstrap.servers}")
    private String hosts;

    @Value("${spring.kafka.producer.key.serializer}")
    private String key;

    @Value("${spring.kafka.producer.value.serializer}")
    private String value;

    @Value("${acks}")
    private String acks;

    @Value("${retries}")
    private String retries;
    
    @Value("${linger.ms}")
    private String ms;
    
    @Value("${buffer.memory}")
    private String bufferMemory;
    
    @Value("${group.id}")
    private String groupId;
    
    @Value("${enable.auto.commit)")
    private String autoCommit;
    
    @Value("${auto.commit.interval.ms}")
    private String autoCommitIntervalms;
    
    @Value("${session.timeout.ms}")
    private long sessionTimeoutms;
    
    @Value("${concurrency}")
    private Integer concurrency;

    @Value("${compression.type}")
    private String compressionType;

    // ----------------producer---------------
    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, hosts);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, key);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, value);
        props.put(ProducerConfig.ACKS_CONFIG, acks);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG,Long.parseLong(bufferMemory));
        props.put(ProducerConfig.COMPRESSION_TYPE_CONFIG,compressionType);
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
//        props.put(ProducerConfig.BATCH_SIZE_CONFIG,Integer.parseInt(batchSize));
//        props.put(ProducerConfig.CLIENT_ID_CONFIG,clientId);
//        props.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, Long.parseLong(maxConnectionsIdleMs));
//        props.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, Integer.parseInt(maxRequestSize));
        return props;
    }
    
    
//    public Map<String,Object> 

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    /**
     * 构造kafka模板
     * @return
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

//    @Bean
//    public KafkaAdmin admin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, hosts);
//        return new KafkaAdmin(configs);
//    }
//    
    
    
    
    
    
    /**
     * 构建消息监听器
     * @return
     */
    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>>
                        kafkaListenerContainerFactory() {
    	log.info("配置kafka监听器start......");
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(concurrency);
        factory.getContainerProperties().setPollTimeout(sessionTimeoutms);
        log.info("配置kafka监听器end......");
        return factory;
    }

    @Bean
    public ConsumerFactory<Integer, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, hosts);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,autoCommitIntervalms);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutms);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,key );
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, value);
        return props;
    }
    
    
}
