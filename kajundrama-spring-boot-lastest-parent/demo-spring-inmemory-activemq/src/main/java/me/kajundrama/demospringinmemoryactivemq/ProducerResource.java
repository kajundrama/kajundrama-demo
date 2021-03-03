package me.kajundrama.demospringinmemoryactivemq;

import javax.jms.Queue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

  private final Logger logger = LoggerFactory.getLogger(ProducerResource.class);


  @Autowired
  private Queue queue;

  @Autowired
  private JmsTemplate jmsTemplate;

  @GetMapping("/{message}")
  public String publish(@PathVariable("message") String message) {

    logger.info("message : {}", message);

    jmsTemplate.convertAndSend(queue, message);

    return "Published Successfully!!";
  }
}
