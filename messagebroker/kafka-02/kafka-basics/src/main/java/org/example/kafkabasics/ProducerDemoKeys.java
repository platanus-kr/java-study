package org.example.kafkabasics;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoKeys {

    public static final Logger log = LoggerFactory.getLogger(ProducerDemoKeys.class.getSimpleName());

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

        properties.setProperty("batch.size", "400"); // production 환경에선 이렇게 하면 안됨.
//        properties.setProperty("partitioner.class", RoundRobinPartitioner.class.getName());

        // Producer 생성
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);


        for (int j = 0; j < 2; j++) {


            for (int i = 0; i < 10; i++) {

                String topic = "demo_pac";
                String key = "id_" + i;
                String value = "hello pla " + i;

                // Producer Record 생성
                // $docker exec -ti kafka1 /usr/bin/kafka-topics --create  --bootstrap-server kafka1:19092,kafka2:19093,kafka3:19094 --replication-factor 2 --partitions 4 --topic demo_pac
                ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);


                // data 전송
                producer.send(producerRecord, (metadata, exception) -> { // callback 인자를 받는다.
                    // 레코드가 성공적으로 전송되거나 예외가 발생할 때마다 callback
                    if (exception == null) {
                        // 레코드가 전송됨.
                        log.info("Key : " + key + " | Partition : " + metadata.partition());
                    } else {
                        log.error("producing 중 에러 발생 ", exception);
                    }
                });

                // partitioner.class = null -> uniform partitioner
                // 이 경우 sticky partitioner 정책으로 같은 partition에 정착된다.
                // sticky partitioner가 성능적으로 round robin보다 낫다.
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


        // producer에게 전달하고 모든 데이터 전송 후 완료될떄까지 블록 -- 동기
        producer.flush();

        // Producer의 flush와 종료
        producer.close();
    }
}
