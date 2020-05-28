package com.cp.springcloud.consumer.util;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;
import java.util.Properties;

/**
 * @auther CPP
 * @date 2020/5/21 15:26
 */
public class Kafka_consumer extends Thread {
    private final KafkaConsumer<Integer,String> consumer;
    public Kafka_consumer(String topic){
        Properties properties =new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "192.168.126.10:9092,192.168.126.11:9092,192.168.126.12:9092");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG,"Kafka_consumer1");
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,"true");
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,"1000");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringDeserializer");

        consumer = new KafkaConsumer<Integer, String>(properties);
        consumer.subscribe(Collections.singletonList(topic));
    }
    @Override
    public void run() {

        while (true){

            ConsumerRecords<Integer, String> poll = consumer.poll(1000);
            for (ConsumerRecord record:poll) {
                System.out.println("接受的信息 = " + record.value());

            }

        }
    }

    public static void main(String[] args) {
        new Kafka_consumer("cpp").start();
    }
}
