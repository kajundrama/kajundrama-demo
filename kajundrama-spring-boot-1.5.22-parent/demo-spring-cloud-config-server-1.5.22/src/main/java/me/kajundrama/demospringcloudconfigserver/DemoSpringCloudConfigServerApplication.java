package me.kajundrama.demospringcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class DemoSpringCloudConfigServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(DemoSpringCloudConfigServerApplication.class, args);
  }

}
