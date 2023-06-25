# Kafka client producer-consumer example

> Java 17   
> IntelliJ   
> Docker, docker-compose   
> Confluent Kafka 7.3.3   
> UI for Apache Kafka

### 로컬에서 실행하기

```bash
cd ./misc
docker-compose -f docker-compose.yml up -d
```

이하 4개의 컨테이너가 만들어지고 실행된다

- kafka-ui
- kafka-gen
- kafka1, kafka2, kafka3

`kafka-ui` : 카프카 GUI 클라이언트   
`kafka-gen` : KRaft모드를 위한 클러스터 식별자 생성기   
`kafka1~3` : 클러스터 유지를 위한 최소한의 카프카 컨테이너   

**참고문서**

> https://www.conduktor.io/kafka/advanced-kafka-consumer-with-java/
> https://github.com/provectus/kafka-ui   
> https://docs.kafka-ui.provectus.io/configuration/quick-start   
> https://github.com/katyagorshkova/kafka-kraft
