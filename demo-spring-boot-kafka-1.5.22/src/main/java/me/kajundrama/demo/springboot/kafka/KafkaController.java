package me.kajundrama.demo.springboot.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
@RequiredArgsConstructor
@Slf4j
public class KafkaController {

  @Autowired
  private CustomProducer producer;

  /**
   * curl -X GET http://localhost:8081/kafka/publish/helloKafka
   * @param message
   */
  @GetMapping("/publish/{message}")
  public void producer(@PathVariable String message){
    log.info(">>> start event publish");
    producer.send(message);
  }

}
