package org.example.kafkabasics;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

public class ConsumerDemo {

    public static final Logger log = LoggerFactory.getLogger(ConsumerDemo.class.getSimpleName());
    public static void main(String[] args) {

        log.info("okay");

        final String groupId = "plata-anywhere-chat";
        final String topic = "demo_pac";

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

        // Consumer 설정
        properties.setProperty("key.deserializer", StringDeserializer.class.getName());
        properties.setProperty("value.deserializer", StringDeserializer.class.getName());

        properties.setProperty("group.id" , groupId);

//        properties.setProperty("auto.offset.reset", "none"); // consumer group이 없을때 작동하지 않음
        properties.setProperty("auto.offset.reset", "earliest"); // 맨 처음부터 토픽을 읽는다.
//        properties.setProperty("auto.offset.reset", "latest"); // 새 메시지만 받는다.

        // Consumer 생성
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);

        // 토픽 구독
//        consumer.subscribe(Arrays.asList("topic1", "topic2"));
        consumer.subscribe(Arrays.asList(topic));

        // 데이터 폴링

        while (true) {
            log.info("polling");

            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));// 과부하 방지를 위한 정책

            for (ConsumerRecord<String, String> record : records) {
                log.info("Key : " + record.key() + " | Value : " + record.value());
                log.info("Partition : " + record.partition() + " | Offset : " + record.offset());
            }

        }

        /**
         * [main] INFO org.apache.kafka.clients.consumer.KafkaConsumer - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Subscribed to topic(s): demo_pac
         * [main] INFO ConsumerDemo - polling
         * [main] INFO org.apache.kafka.clients.Metadata - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Resetting the last seen epoch of partition demo_pac-1 to 0 since the associated topicId changed from null to DeUb4A7MRwmnrSYF20_JVw
         * [main] INFO org.apache.kafka.clients.Metadata - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Resetting the last seen epoch of partition demo_pac-2 to 0 since the associated topicId changed from null to DeUb4A7MRwmnrSYF20_JVw
         * [main] INFO org.apache.kafka.clients.Metadata - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Resetting the last seen epoch of partition demo_pac-0 to 0 since the associated topicId changed from null to DeUb4A7MRwmnrSYF20_JVw
         * [main] INFO org.apache.kafka.clients.Metadata - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Cluster ID: 6u1AxJ7cTWOP_-dAvu1XtA
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Discovered group coordinator kafka1:39092 (id: 2147483646 rack: null)
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] (Re-)joining group
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Group coordinator kafka1:39092 (id: 2147483646 rack: null) is unavailable or invalid due to cause: error response NOT_COORDINATOR. isDisconnected: false. Rediscovery will be attempted.
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Requesting disconnect from last known coordinator kafka1:39092 (id: 2147483646 rack: null)
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] JoinGroup failed: This is not the correct coordinator. Marking coordinator unknown. Sent generation was Generation{generationId=-1, memberId='', protocol='null'}
         * [main] INFO org.apache.kafka.clients.NetworkClient - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Client requested disconnect from node 2147483646
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Discovered group coordinator kafka1:39092 (id: 2147483646 rack: null)
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Group coordinator kafka1:39092 (id: 2147483646 rack: null) is unavailable or invalid due to cause: coordinator unavailable. isDisconnected: false. Rediscovery will be attempted.
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Requesting disconnect from last known coordinator kafka1:39092 (id: 2147483646 rack: null)
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Discovered group coordinator kafka1:39092 (id: 2147483646 rack: null)
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Request joining group due to: rebalance failed due to 'This is not the correct coordinator.' (NotCoordinatorException)
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] (Re-)joining group
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Request joining group due to: need to re-join with the given member-id: consumer-plata-anywhere-chat-1-18fa4fe2-a112-491a-b38b-02f464c3aa3a
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Request joining group due to: rebalance failed due to 'The group member needs to have a valid member id before actually entering a consumer group.' (MemberIdRequiredException)
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] (Re-)joining group
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Successfully joined group with generation Generation{generationId=1, memberId='consumer-plata-anywhere-chat-1-18fa4fe2-a112-491a-b38b-02f464c3aa3a', protocol='range'}
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Finished assignment for group at generation 1: {consumer-plata-anywhere-chat-1-18fa4fe2-a112-491a-b38b-02f464c3aa3a=Assignment(partitions=[demo_pac-0, demo_pac-1, demo_pac-2])}
         * [main] INFO ConsumerDemo - polling
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Successfully synced group in generation Generation{generationId=1, memberId='consumer-plata-anywhere-chat-1-18fa4fe2-a112-491a-b38b-02f464c3aa3a', protocol='range'}
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Notifying assignor about the new Assignment(partitions=[demo_pac-0, demo_pac-1, demo_pac-2])
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Adding newly assigned partitions: demo_pac-0, demo_pac-1, demo_pac-2
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Found no committed offset for partition demo_pac-2
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Found no committed offset for partition demo_pac-1
         * [main] INFO org.apache.kafka.clients.consumer.internals.ConsumerCoordinator - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Found no committed offset for partition demo_pac-0
         * [main] INFO org.apache.kafka.clients.consumer.internals.SubscriptionState - [Consumer clientId=consumer-plata-anywhere-chat-1, groupId=plata-anywhere-chat] Resetting offset for partition demo_pac-1 to position FetchPosition{offset=0, offsetEpoch=Optional.empty, currentLeader=LeaderAndEpoch{leader=Optional[kafka1:39092 (id: 1 rack: null)], epoch=0}}.
         */


    }
}
