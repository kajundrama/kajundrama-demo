package me.kajundrama.demo.springboot.kafka;

import java.util.Properties;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * <pre>
 *   Kafka Consumer 애제 클래스
 * </pre>
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CustomConsumer {

  private final KafkaConfig config;
  private KafkaConsumer<String, String> consumer = null;

  @PostConstruct
  public void build() {
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, config.getConsumer().getGroupId());
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
        config.getConsumer().getKeyDeserializer());
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
        config.getConsumer().getValueDeserializer());
    properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,
        config.getConsumer().getAutoOffsetReset());
    properties.setProperty(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,
        config.getConsumer().getMaxPollRecords());
    properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,
        config.getConsumer().getEnableAutoCommit());
    consumer = new KafkaConsumer<>(properties);
  }

  @KafkaListener(topics = "${spring.kafka.template.default-topic}")
  public void consume(@Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Payload String payload) {
    log.info("CONSUME TOPIC : " + topic);
    log.info("CONSUME PAYLOAD : " + payload);
  }

}
