package me.kajundrama.demospringinmemoryactivemq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

  private final Logger logger = LoggerFactory.getLogger(Consumer.class);

  @JmsListener(destination = "inmemory.queue")
  public void listener(String message) {
    logger.info("listener : {}", message);

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    logger.info("listener later : {}", message);
  }

}
