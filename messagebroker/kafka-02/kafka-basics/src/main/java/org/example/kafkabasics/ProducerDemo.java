package org.example.kafkabasics;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {

    public static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());
    public static void main(String[] args) {

        log.info("okay");

        // Producer properties 생성

        Properties properties = new Properties();
//        properties.setProperty("key", "value");

        // 일반연결
        properties.setProperty("bootstrap.servers", "localhost:39092,localhost:39093,localhost:39094"); // kraft container

        // 보안연결
//        properties.setProperty("bootstrap.servers", "");
//        properties.setProperty("security.protocol", "SASL_SSL");
//        properties.setProperty("sasl.jaas.config", "");
//        properties.setProperty("sasl.mechanism", "");

        // Producer properties 설정
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer", StringSerializer.class.getName());

        // Producer 생성
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        // Producer Record 생성
        // $docker exec -ti kafka1 /usr/bin/kafka-topics --create  --bootstrap-server kafka1:19092,kafka2:19093,kafka3:19094 --replication-factor 2 --partitions 4 --topic demo_pac
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_pac", "hello platanus");

        // data 전송
        producer.send(producerRecord);

        // producer에게 전달하고 모든 데이터 전송 후 완료될떄까지 블록 -- 동기
        producer.flush();

        // Producer의 flush와 종료
        producer.close();
    }
}
