package org.kafka01;

import static org.kafka01.Constants.TOPIC_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class KafkaPubService {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	//public void sendMessage(String msg) {
	//	kafkaTemplate.send(TOPIC_NAME, msg);
	//}

	public void sendMessage(String msg) {
		ListenableFuture<SendResult<String, String>> future =
				kafkaTemplate.send(TOPIC_NAME, msg);

		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

			@Override
			public void onSuccess(SendResult<String, String> result) {
				System.out.println("Sent message=[" + msg +
						"] with offset=[" + result.getRecordMetadata().offset() + "]");
			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("Unable to send message=["
						+ msg + "] due to : " + ex.getMessage());
			}
		});
	}

}
