package com.cp.springcloud.consumer.util;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @auther CPP
 * @date 2020/5/21 14:54
 */
public class Kafka_provider extends Thread {

    private final KafkaProducer<Integer, String> kafkaProducer;

    private final String topic;

    public Kafka_provider(String topic) {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "192.168.126.10:9092,192.168.126.11:9092,192.168.126.12:9092");
        properties.put(ProducerConfig.CLIENT_ID_CONFIG,"Kafka_provider");
        properties.put(ProducerConfig.ACKS_CONFIG,"-1");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                "org.apache.kafka.common.serialization.StringSerializer");

        kafkaProducer=new KafkaProducer<Integer, String>(properties);
        this.topic = topic;
    }

    public void run() {
        int num = 0;
        while (num<=100){
            String message = "sendMessage"+num;
            System.out.println("message = " + message);
            kafkaProducer.send(new ProducerRecord<Integer, String>(topic,message));
            num++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Kafka_provider("cpp").start();
    }
}

