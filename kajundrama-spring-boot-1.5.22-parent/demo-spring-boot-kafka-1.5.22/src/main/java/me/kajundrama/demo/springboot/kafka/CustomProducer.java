package me.kajundrama.demo.springboot.kafka;

import java.util.Properties;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomProducer {

  private final KafkaConfig config;
  private KafkaProducer<String, String> producer = null;

  @PostConstruct
  public void build() {
    Properties properties = new Properties();
    properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, config.getBootstrapServers());
    properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
        config.getProducer().getKeySerializer());
    properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
        config.getProducer().getValueSerializer());
    producer = new KafkaProducer<>(properties);
  }

  public void send(String message) {
    ProducerRecord<String, String> record = new ProducerRecord<>(
        config.getTemplate().getDefaultTopic(), message);

    producer.send(record, new Callback() {
      @Override
      public void onCompletion(RecordMetadata metadata, Exception exception) {
        log.info("publish message: {}", message);
        if (exception != null) {
          log.info(exception.getMessage());
        }
      }
    });
  }

}
