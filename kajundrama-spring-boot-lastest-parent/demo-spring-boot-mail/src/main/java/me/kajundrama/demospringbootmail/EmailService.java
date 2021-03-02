package me.kajundrama.demospringbootmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

  /**
   * Logger
   */
  private final Logger logger = LoggerFactory.getLogger(EmailService.class);

  @Autowired
  private JavaMailSender javaMailSender;

  public void send(String from, String to, String body, String topic) {

    logger.info("sending Email from[{}] to[{}]", from, to);
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(from);
    message.setTo(to);
    message.setSubject(topic);
    message.setText(body);
    javaMailSender.send(message);
    logger.info("send OK");

  }
}
