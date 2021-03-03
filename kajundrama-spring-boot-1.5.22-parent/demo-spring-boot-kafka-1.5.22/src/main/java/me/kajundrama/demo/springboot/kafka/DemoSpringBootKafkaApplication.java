package me.kajundrama.demo.springboot.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <pre>
 *   Spring Boot 1.5.12.RELEASE 버전에서 Kafka 연계를 위한 예제 Application 입니다.
 * </pre>
 */
@SpringBootApplication
public class DemoSpringBootKafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringBootKafkaApplication.class, args);
  }

}
