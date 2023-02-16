package org.kafka01;

import static org.kafka01.Constants.GROUP_ID;
import static org.kafka01.Constants.TOPIC_NAME;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumeService {
	@KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
	public void listenGroupFoo(String message) {
		System.out.println("Received Message in group foo: " + message);
	}

	@KafkaListener(topics = TOPIC_NAME)
	public void listenWithHeaders(
			@Payload String message,
			@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
		System.out.println(
				"Received Message: " + message
						+ "from partition: " + partition);
	}

	//@KafkaListener(
	//		topics = TOPIC_NAME,
	//		containerFactory = "filterKafkaListenerContainerFactory")
	//public void listenWithFilter(String message) {
	//	System.out.println("Received Message in filtered listener: " + message);
	//}

	//@KafkaListener(
	//		topicPartitions = @TopicPartition(topic = TOPIC_NAME,
	//				partitionOffsets = {
	//						@PartitionOffset(partition = "0", initialOffset = "0"),
	//						@PartitionOffset(partition = "3", initialOffset = "0")}),
	//		containerFactory = "partitionsKafkaListenerContainerFactory")
	//public void listenToPartition(
	//		@Payload String message,
	//		@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
	//	System.out.println(
	//			"Received Message: " + message
	//					+ "from partition: " + partition);
	//}

}
