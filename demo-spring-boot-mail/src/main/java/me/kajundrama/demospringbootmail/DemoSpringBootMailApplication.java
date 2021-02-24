package me.kajundrama.demospringbootmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class DemoSpringBootMailApplication {


  @Autowired
  private EmailService emailService;

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringBootMailApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void triggerWhenStarts() {
    String from = "kajundrama2@gmail.com";
    String to = "kajundrama@gmail.com";
    String topic = "Mail Send Test From SpringBoot";
    String body = "This message is from 'Demo Spring Boot Mail App'";
    emailService.send(from, to, body, topic);
  }

}
