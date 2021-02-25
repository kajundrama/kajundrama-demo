package me.kajundrama.demospringbootmail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {EmailService.class, JavaMailSender.class})
public class EmailServiceTest {

  @Autowired
  private EmailService emailService;

  @Test
  public void testSendEmail() {
    String from = "kajundrama2@gmail.com";
    String to = "kajundrama@gmail.com";
    String topic = "Mail Send Test From SpringBoot";
    String body = "This message is from 'Demo Spring Boot Mail App'";
    //emailService.send(from, to, body, topic);
  }


}